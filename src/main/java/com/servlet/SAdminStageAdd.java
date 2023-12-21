package com.servlet;

import com.dao.StageDao;
import com.dao.impl.StageDaoImpl;
import com.entity.Stage;
import com.util.Message;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author xtaod
 */
@WebServlet("/sadmin/stageadd.do")
public class SAdminStageAdd extends HttpServlet {
    private Timestamp parseTime(String form) {
        return Timestamp.valueOf(form.replace('T', ' ') + ":00");
    }

    private void stageAdd(StageDao stageDao, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        HttpSession session = request.getSession();
        int stagenum = Integer.parseInt(request.getParameter("stagenum"));
        Stage stage = new Stage();
        stage.setStagenum(stagenum);
        stage.setStagename(request.getParameter("stagename"));
        stage.setStarttime(parseTime(request.getParameter("starttime")));
        stage.setEndtime(parseTime(request.getParameter("endtime")));
        stage.setNote(request.getParameter("note"));
        if (stageDao.findByStagenum(stagenum) != null) {
            session.setAttribute("mess", new Message("stageAddMess", "阶段编号不能重复！"));
        } else if (stageDao.add(stage) != 0) {
            servletContext.setAttribute("stages", stageDao.findAll());
            session.setAttribute("mess", new Message("stageAddMess", "添加阶段成功！"));
        } else {
            session.setAttribute("mess", new Message("stageAddMess", "添加阶段失败"));
        }
        response.sendRedirect(servletContext.getContextPath() + "/sadmin/stageadd.jsp#add");
    }

    private void stageDelete(StageDao stageDao, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        HttpSession session = request.getSession();
        int stagenum = Integer.parseInt(request.getParameter("stagenum"));
        if (stageDao.deleteByStagenum(stagenum) != 0) {
            servletContext.setAttribute("stages", stageDao.findAll());
            session.setAttribute("mess", new Message("stageDeleteMess", "阶段删除成功！"));
        } else {
            session.setAttribute("mess", new Message("stageDeleteMess", "阶段删除失败！"));
        }
        response.sendRedirect(servletContext.getContextPath() + "/sadmin/stageadd.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        StageDao stageDao = new StageDaoImpl();
        if ("stageDelete".equals(action)) {
            stageDelete(stageDao, request, response);
        } else {
            session.removeAttribute("mess");
            response.sendRedirect(servletContext.getContextPath() + "/sadmin/stageadd.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        String action = request.getParameter("action");
        StageDao stageDao = new StageDaoImpl();
        if ("stageAdd".equals(action)) {
            stageAdd(stageDao, request, resp);
        }
    }
}
