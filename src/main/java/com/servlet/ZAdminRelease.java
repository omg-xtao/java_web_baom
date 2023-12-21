package com.servlet;

import com.dao.SchoolDao;
import com.dao.impl.SchoolDaoImpl;
import com.entity.School;
import com.util.BeanUtil;
import com.util.Message;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xtaod
 */
@WebServlet("/zadmin/release.do")
public class ZAdminRelease extends HttpServlet {
    private void schoolAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        SchoolDao schoolDao = new SchoolDaoImpl();
        School school = BeanUtil.mapToBean(School.class, request.getParameterMap());
        if (schoolDao.add(school) != 0) {
            servletContext.setAttribute("school", school);
            session.setAttribute("mess", new Message("schoolAddMess", "学校基本信息设置成功！"));
        } else {
            session.setAttribute("mess", new Message("schoolAddMess", "学校基本信息设置失败！"));
        }
        response.sendRedirect(servletContext.getContextPath() + "/zadmin/release.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("schoolAdd".equals(action)) {
            schoolAdd(req, resp);
        }
    }
}
