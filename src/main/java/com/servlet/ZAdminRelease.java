package com.servlet;

import com.dao.MajorDao;
import com.dao.SchoolDao;
import com.dao.impl.MajorDaoImpl;
import com.dao.impl.SchoolDaoImpl;
import com.entity.Major;
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

    private void majorDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        MajorDao majorDao = new MajorDaoImpl();
        String mcode = request.getParameter("mcode");
        Major major = majorDao.findByMcode(mcode);
//        if (major != null && !courseDao.findByCmname(major.getMname()).isEmpty()){
//            session.setAttribute("mess", new Message("majorDeleteMess", "请先删除'"+major.getMname()+"'专业的所有课程！"));
//        } else
        if (majorDao.deleteByMcode(mcode) != 0) {
            servletContext.setAttribute("majors", majorDao.findAll());
            session.setAttribute("mess", new Message("majorDeleteMess", "专业删除成功！"));
        } else {
            session.setAttribute("mess", new Message("majorDeleteMess", "专业删除失败！"));
        }
        response.sendRedirect(servletContext.getContextPath() + "/zadmin/release.jsp");
    }

    private void majorAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        MajorDao majorDao = new MajorDaoImpl();
        Major major = BeanUtil.mapToBean(Major.class, request.getParameterMap());
        if (majorDao.add(major) != 0) {
            servletContext.setAttribute("majors", majorDao.findAll());
            session.setAttribute("mess", new Message("majorAddMess", "专业添加成功！"));
        } else {
            session.setAttribute("mess", new Message("majorAddMess", "专业添加失败！"));
        }
        response.sendRedirect(servletContext.getContextPath() + "/zadmin/release.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("schoolAdd".equals(action)) {
            schoolAdd(req, resp);
        } else if ("majorAdd".equals(action)) {
            majorAdd(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("majorDelete".equals(action)) {
            majorDelete(req, resp);
        }
    }
}
