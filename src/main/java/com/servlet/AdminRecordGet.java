package com.servlet;

import com.dao.RecordDao;
import com.dao.impl.RecordDaoImpl;
import com.entity.AdminUser;
import com.util.PageModel;

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
@WebServlet("/admin/record.do")
public class AdminRecordGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        RecordDao recordDao = new RecordDaoImpl();
        AdminUser user = (AdminUser) session.getAttribute("adminuser");
        if (user == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        String pageNoS = request.getParameter("pageNo");
        int pageNo = 1;
        try {
            pageNo = Integer.parseInt(pageNoS);
        } catch (NumberFormatException ignored) {
        }
        PageModel pm = recordDao.pageByLogname(user.getAdminname(), user.getAdmingroup(), 10, pageNo);
        pm.setPageNav("record.do");
        request.setAttribute("pm", pm);
        request.getRequestDispatcher("/admin/record.jsp").forward(request, response);
    }
}
