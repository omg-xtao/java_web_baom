package com.servlet;

import com.dao.RecordDao;
import com.dao.impl.RecordDaoImpl;
import com.entity.AdminUser;
import com.util.PageModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xtaod
 */
@WebServlet("/admin/record.do")
public class AdminRecordGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        PageModel page = recordDao.pageByLogname(user.getAdminname(), user.getAdmingroup(), 10, pageNo);
        page.setPageNav("record.do");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"zh-CN\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>登录日志</title>");
        out.println("</head>\n<body>");
        out.println(page.getContent());
        out.println(page.getPageNav());
        out.println("</body>\n</html>");
    }
}
