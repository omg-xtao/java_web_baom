package com.servlet;

import com.dao.GradeDao;
import com.dao.MajorDao;
import com.dao.ReginfoDao;
import com.dao.impl.GradeImpl;
import com.dao.impl.MajorDaoImpl;
import com.dao.impl.ReginfoDaoImpl;
import com.entity.GradeVo;
import com.entity.Major;
import com.entity.Reginfo;
import com.util.HttpServletInit;
import com.util.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xtaod
 */
@WebServlet("/zadmin/line.do")
public class ZAdminLine extends HttpServletInit {
    private HashMap<String, Float> getScoreMap(GradeDao gradeDao, String mName) {
        // 获得所有参考 mname 的考生成绩
        ArrayList<GradeVo> grades = gradeDao.findByMName(mName);
        // 创建考试成绩 map
        HashMap<String, Float> map = new HashMap<>();
        for (GradeVo grade : grades) {
            float score = map.getOrDefault(grade.getTestcardnum(), 0.0F);
            score += grade.getScore();
            map.put(grade.getTestcardnum(), score);
        }
        return map;
    }

    private float getPassScore(HashMap<String, Float> map, AtomicInteger passNum) {
        // 排序，将考试成绩从高到低排序
        ArrayList<String> testCardNums = new ArrayList<>(map.keySet());
        testCardNums.sort((o1, o2) -> {
            float score1 = map.get(o1);
            float score2 = map.get(o2);
            return Float.compare(score2, score1);
        });
        // 获取录取分数
        if (passNum.get() > testCardNums.size()) {
            passNum.set(testCardNums.size());
        }
        return map.get(testCardNums.get(passNum.get() - 1));
    }

    private void trySetLine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mcode = request.getParameter("mcode");
        if (mcode == null || mcode.isEmpty()) {
            return;
        }
        MajorDao majorDao = new MajorDaoImpl();
        GradeDao gradeDao = new GradeImpl();
        Major major = majorDao.findByMcode(mcode);
        if (major == null) {
            return;
        }
        String mName = major.getMname();
        // 获取 <准考证号, 总分> map
        HashMap<String, Float> map = getScoreMap(gradeDao, mName);
        // 获取录取分数和录取人数
        float passScore = major.getPassscore();
        AtomicInteger passNum = new AtomicInteger(major.getPlannum());
        if (major.getAdmitnum() <= 0) {
            passScore = getPassScore(map, passNum);
        }
        request.getSession().setAttribute("scoremap", map);
        request.setAttribute("passcode", passScore);
        request.setAttribute("passnum", passNum.get());
        request.setAttribute("mcode", mcode);
        request.getRequestDispatcher("/zadmin/line.jsp").forward(request, response);
    }

    private void resetAdmitByMName(ReginfoDao reginfoDao, String mName) {
        ArrayList<Reginfo> reginfos = reginfoDao.findByMName(mName);
        for (Reginfo reg : reginfos) {
            reg.setIsadmit(false);
            reginfoDao.update(reg);
        }
    }

    private int setAdmitByScore(ReginfoDao reginfoDao, HashMap<String, Float> map, float score, String mName) {
        // 获取大于等于 score 的准考证号
        ArrayList<String> testCardNums = new ArrayList<>();
        for (String testCardNum : map.keySet()) {
            if (map.get(testCardNum) >= score) {
                testCardNums.add(testCardNum);
            }
        }
        int admitNum = testCardNums.size();
        // 设置录取
        ArrayList<Reginfo> regs = reginfoDao.findByMName(mName);
        for (Reginfo reg : regs) {
            if (testCardNums.contains(reg.getTestcardnum())) {
                reg.setIsadmit(true);
                reginfoDao.update(reg);
            }
        }
        return admitNum;
    }

    private void setLine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Float> map = (HashMap<String, Float>) req.getSession().getAttribute("scoremap");
        String mcode = req.getParameter("mcode");
        String passcode = req.getParameter("passcode");
        if (mcode == null || mcode.isEmpty()) {
            return;
        }
        MajorDao majorDao = new MajorDaoImpl();
        Major major = majorDao.findByMcode(mcode);
        if (major == null) {
            return;
        }
        String mName = major.getMname();
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        resetAdmitByMName(reginfoDao, mName);
        float score;
        if (passcode == null || passcode.isEmpty()) {
            score = getPassScore(map, new AtomicInteger(major.getPlannum()));
        } else {
            score = Float.parseFloat(passcode);
        }
        int admitNum = setAdmitByScore(reginfoDao, map, score, mName);
        major.setPassscore(score);
        major.setAdmitnum(admitNum);
        majorDao.update(major);

        req.getSession().setAttribute("mess", new Message("lineMess", "设置成功，录取分数为：" + score + "，录取人数为：" + admitNum + "人"));
        req.setAttribute("passcode", score);
        req.setAttribute("passnum", admitNum);
        req.setAttribute("mcode", mcode);
        req.getRequestDispatcher("/zadmin/line.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setLine(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        trySetLine(req, resp);
    }
}
