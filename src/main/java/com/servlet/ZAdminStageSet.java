package com.servlet;

import com.dao.CurrStageDao;
import com.dao.impl.CurrStageDaoImpl;
import com.entity.AdminUser;
import com.util.HttpServletInit;
import com.util.Message;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xtaod
 */
@WebServlet("/zadmin/stageset.do")
public class ZAdminStageSet extends HttpServletInit {
    private void stageSet(CurrStageDao currstageDao, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        AdminUser adminuser = (AdminUser) session.getAttribute("adminuser");
        String adminname = adminuser.getAdminname();
        String currstage = request.getParameter("currstage");
        if (currstageDao.set(adminname, currstage) != 0) {
            initStage(request);
            session.setAttribute("mess", new Message("stageSetMess", "阶段设置成功！"));
        } else {
            session.setAttribute("mess", new Message("stageSetMess", "阶段设置失败！"));
        }
        response.sendRedirect(servletContext.getContextPath() + "/zadmin/stageset.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        CurrStageDao currStageDao = new CurrStageDaoImpl();
        if ("stageSet".equals(action)) {
            stageSet(currStageDao, req, resp);
        }
    }
}
