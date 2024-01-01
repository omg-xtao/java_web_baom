package com.filter;

import com.entity.CurrStage;
import com.entity.Stage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


enum StuStage {
    Register("/register"),
    Entry("/stu/entry"),
    Photo("/stu/photo"),
    EntryPrint("/stu/entry_print"),
    CardPrint("/stu/card_print"),
    Grade("/stu/grade");

    private final String path;

    StuStage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

enum AdminStage {
    Grade("/admin/grade");

    private final String path;

    AdminStage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

enum ZAdminStage {
    Release("/zadmin/release"),
    Confirm("/zadmin/confirm"),
    Line("/zadmin/line");

    private final String path;

    ZAdminStage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

enum JAdminStage {
    AssignNum("/jadmin/assignnum"),
    AssignRoom("/jadmin/assignroom"),
    Grade("/jadmin/grade");

    private final String path;

    JAdminStage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

/**
 * @author xtaod
 */
public class StageFilter implements Filter {
    ArrayList<String> allStage = new ArrayList<String>() {{
        add(StuStage.Register.getPath());
        add(StuStage.Entry.getPath());
        add(StuStage.Photo.getPath());
        add(StuStage.EntryPrint.getPath());
        add(StuStage.CardPrint.getPath());
        add(StuStage.Grade.getPath());
        add(AdminStage.Grade.getPath());
        add(ZAdminStage.Release.getPath());
        add(ZAdminStage.Confirm.getPath());
        add(ZAdminStage.Line.getPath());
        add(JAdminStage.AssignNum.getPath());
        add(JAdminStage.AssignRoom.getPath());
        add(JAdminStage.Grade.getPath());
    }};
    HashMap<Integer, ArrayList<String>> stageNumDisallowMap = getStageNumDisallowMap();

    HashMap<Integer, ArrayList<String>> getStageNumDisallowMap() {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        // 招考信息发布
        ArrayList<String> stage1 = new ArrayList<>(allStage);
        stage1.remove(ZAdminStage.Release.getPath());
        // 在线报名
        ArrayList<String> stage2 = new ArrayList<>(allStage);
        stage2.remove(StuStage.Register.getPath());
        stage2.remove(StuStage.Entry.getPath());
        stage2.remove(StuStage.Photo.getPath());
        stage2.remove(StuStage.EntryPrint.getPath());
        // 现场确认
        ArrayList<String> stage3 = new ArrayList<>(stage2);
        stage3.remove(ZAdminStage.Confirm.getPath());
        // 考号和考场分配
        ArrayList<String> stage4 = new ArrayList<>(allStage);
        stage4.remove(JAdminStage.AssignNum.getPath());
        stage4.remove(JAdminStage.AssignRoom.getPath());
        // 准考证打印
        ArrayList<String> stage5 = new ArrayList<>(allStage);
        stage5.remove(StuStage.CardPrint.getPath());
        // 成绩录入
        ArrayList<String> stage6 = new ArrayList<>(allStage);
        stage6.remove(JAdminStage.Grade.getPath());
        // 设置录取分数线
        ArrayList<String> stageC = new ArrayList<>(allStage);
        stageC.remove(AdminStage.Grade.getPath());
        ArrayList<String> stage7 = new ArrayList<>(stageC);
        stage7.remove(ZAdminStage.Line.getPath());
        // 成绩与录取查询
        ArrayList<String> stage8 = new ArrayList<>(stageC);
        stage8.remove(StuStage.Grade.getPath());

        map.put(1, stage1);
        map.put(2, stage2);
        map.put(3, stage3);
        map.put(4, stage4);
        map.put(5, stage5);
        map.put(6, stage6);
        map.put(7, stage7);
        map.put(8, stage8);
        return map;
    }

    ArrayList<String> getStageDisallowMap(ServletContext context) {
        ArrayList<Stage> stages = (ArrayList<Stage>) context.getAttribute("stages");
        CurrStage currstage = (CurrStage) context.getAttribute("currstage");
        int stageNum = 0;
        for (int i = 0; i < stages.size(); i++) {
            if (Objects.equals(stages.get(i).getStagename(), currstage.getStagename())) {
                stageNum = i + 1;
                break;
            }
        }
        if (stageNum == 0) {
            return null;
        }
        return stageNumDisallowMap.get(stageNum);
    }

    void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        String notice = "* 系统当前所处阶段不允许此操作";
        if (session.getAttribute("username") != null) {
            // 学生
            req.setAttribute("Mess", notice);
            req.getRequestDispatcher("/stu/notice.jsp").forward(request, response);
        } else if (session.getAttribute("adminuser") != null) {
            // 管理员
            req.setAttribute("Mess", notice);
            req.getRequestDispatcher("/admin/state.jsp").forward(request, response);
        } else {
            // 未登录用户
            req.setAttribute("stuLoginMess", notice);
            req.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String reqPath = ((HttpServletRequest) request).getServletPath();
        ArrayList<String> disallowMap = getStageDisallowMap(request.getServletContext());
        if (disallowMap == null) {
            chain.doFilter(request, response);
        } else {
            boolean disallow = false;
            for (String vPath : disallowMap) {
                if (reqPath.startsWith(vPath)) {
                    disallow = true;
                    break;
                }
            }

            if (!disallow) {
                chain.doFilter(request, response);
            } else {
                forward(request, response);
            }
        }
    }
}
