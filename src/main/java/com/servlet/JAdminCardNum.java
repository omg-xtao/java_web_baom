package com.servlet;

import com.dao.ReginfoDao;
import com.dao.impl.ReginfoDaoImpl;
import com.entity.Major;
import com.entity.Reginfo;
import com.entity.School;
import com.util.CardGenXlsx;
import com.util.Message;
import com.util.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xtaod
 */
@WebServlet("/jadmin/assignnum.do")
public class JAdminCardNum extends HttpServlet {
    private String cardNumPre;
    HashMap<String, String> majorCodeMap = new HashMap<>();
    HashMap<String, Integer> majorNumMap = new HashMap<>();
    ArrayList<Reginfo> reginfos;

    private String getCardNum(Reginfo reginfo) {
        String major = reginfo.getMname();
        Integer num = majorNumMap.get(major);
        int i = num + 1;
        majorNumMap.put(major, i);
        return cardNumPre + majorCodeMap.get(major) + String.format("%03d", i);
    }

    private void initAssign() {
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        reginfos = reginfoDao.findAll(true);
        School school = (School) this.getServletContext().getAttribute("school");
        ArrayList<Major> majors = (ArrayList<Major>) this.getServletContext().getAttribute("majors");
        String shoolCode = school.getShcode();
        String year = school.getShyear();
        cardNumPre = year + shoolCode;
        majorCodeMap.clear();
        for (Major major : majors) {
            majorCodeMap.put(major.getMname(), major.getMcode());
        }
        majorNumMap.clear();
        for (Major major : majors) {
            majorNumMap.put(major.getMname(), 0);
        }
        for (Reginfo reginfo : reginfos) {
            reginfo.setTestcardnum(getCardNum(reginfo));
        }
    }

    private void testAssign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
        int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
        if (reginfos == null) {
            initAssign();
        }
        PageModel pm = new PageModel(pageSize, pageNo, null, reginfos);
        pm.setPageNav(request.getRequestURI());
        request.setAttribute("pm", pm);
        request.getRequestDispatcher("/jadmin/assignnum.jsp").forward(request, response);
    }

    private void applyAssign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        initAssign();
        for (Reginfo reginfo : reginfos) {
            reginfoDao.update(reginfo);
        }
        (new CardGenXlsx(request.getServletContext().getRealPath("/"), null, null)).deleteAll();
        request.getSession().setAttribute("mess", new Message("assignMess", "分配成功"));
        request.getRequestDispatcher("/jadmin/assignnum.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("assign".equals(action)) {
            applyAssign(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        testAssign(req, resp);
    }
}
