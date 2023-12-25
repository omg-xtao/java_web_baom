package com.servlet;

import com.dao.StuDao;
import com.dao.impl.StuDaoImpl;
import com.entity.Stu;
import com.util.Encrypt;

import javax.servlet.ServletContext;
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
@WebServlet("/zadmin/manage.do")
public class ZAdminStuManage extends HttpServlet {
    private void findStusLikeUsername(StuDao stuDao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        ArrayList<Stu> stus = stuDao.findStusLikeUsername(username);
        request.setAttribute("stus", stus);
        request.getRequestDispatcher("/zadmin/stumanage.jsp").forward(request, response);
    }

    private void findStusLikeIdcode(StuDao stuDao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idcode = request.getParameter("idcode");
        ArrayList<Stu> stus = stuDao.findStusLikeIdcode(idcode);
        request.setAttribute("stus", stus);
        request.getRequestDispatcher("/zadmin/stumanage.jsp").forward(request, response);
    }

    private void stuPassReset(StuDao stuDao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (stuDao.passModify(username, Encrypt.SHA("000000")) != 0) {
            request.setAttribute("stuPassResetMess", "* 用户 " + username + " 的密码已重置为‘000000’！");
            request.getRequestDispatcher("/zadmin/stumanage.jsp").forward(request, response);
        } else {
            request.setAttribute("stuPassResetMess", "* 用户 " + username + " 的密码清零操作失败！");
            request.getRequestDispatcher("/zadmin/stumanage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        StuDao stuDao = new StuDaoImpl();
        if ("stuPassReset".equals(action)) {
            stuPassReset(stuDao, request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        ServletContext servletContext = request.getServletContext();
        StuDao stuDao = new StuDaoImpl();
        String action = request.getParameter("action");
        if ("find".equals(action)) {
            String username = request.getParameter("username");
            String idcode = request.getParameter("idcode");
            request.setAttribute("username", username);
            request.setAttribute("idcode", idcode);
            if (username != null && !username.isEmpty()) {
                findStusLikeUsername(stuDao, request, response);
            } else if (idcode != null && !idcode.isEmpty()) {
                findStusLikeIdcode(stuDao, request, response);
            } else {
                response.sendRedirect(servletContext.getContextPath() + "/zadmin/stumanage.jsp");
            }
        } else {
            response.sendRedirect(servletContext.getContextPath() + "/zadmin/stumanage.jsp");
        }
    }
}
