package com.servlet;

import com.dao.GradeDao;
import com.dao.impl.GradeDaoImpl;
import com.entity.Grade;
import com.util.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author xtaod
 */
@WebServlet("/admin/grade.do")
public class AdminGrade extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String testCardNum = req.getParameter("testcardnum");
        String sname = req.getParameter("sname");
        GradeDao gradeDao = new GradeDaoImpl();
        ArrayList<Grade> grades;
        if (testCardNum != null) {
            grades = gradeDao.findByTestcardnum(testCardNum);
        } else if (sname != null) {
            grades = gradeDao.findBySname(sname);
        } else {
            return;
        }
        req.setAttribute("grades", grades);
        req.getSession().setAttribute("mess", new Message("gradeMess" + grades.size(), "共查询到" + grades.size() + "条记录！"));
        req.getRequestDispatcher("/admin/grade.jsp").forward(req, resp);
    }
}
