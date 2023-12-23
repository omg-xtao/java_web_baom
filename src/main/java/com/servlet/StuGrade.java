package com.servlet;

import com.dao.GradeDao;
import com.dao.ReginfoDao;
import com.dao.impl.GradeDaoImpl;
import com.dao.impl.ReginfoDaoImpl;
import com.entity.Grade;
import com.entity.Reginfo;
import com.util.HttpServletInit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author xtaod
 */
@WebServlet("/stu/grade.do")
public class StuGrade extends HttpServletInit {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getSession().getAttribute("username").toString();
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        GradeDao gradeDao = new GradeDaoImpl();
        Reginfo reginfo = reginfoDao.findByUser(username);
        ArrayList<Grade> grades = gradeDao.findByTestcardnum(reginfo.getTestcardnum());
        req.setAttribute("isAdmit", reginfo.getIsadmit() ? "true" : "false");
        req.setAttribute("mname", reginfo.getMname());
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("/stu/grade.jsp").forward(req, resp);
    }
}
