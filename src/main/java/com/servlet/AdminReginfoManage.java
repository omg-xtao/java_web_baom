package com.servlet;

import com.dao.ReginfoDao;
import com.dao.impl.ReginfoDaoImpl;
import com.util.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xtaod
 */
@WebServlet("/admin/reginfomanage.do")
public class AdminReginfoManage extends HttpServlet {
    private void request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
        int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        boolean queryMajorName = true;
        boolean queryIsConfirm = true;
        String majorName = request.getParameter("mname");
        String isconfirm = request.getParameter("isconfirm");
        boolean isConfirm = false;
        if ("all".equals(isconfirm)) {
            queryIsConfirm = false;
        } else {
            isConfirm = "true".equals(isconfirm);
        }
        if ("all".equals(majorName)) {
            queryMajorName = false;
        }
        if (majorName != null) {
            PageModel pm = reginfoDao.pageByMajorName(queryMajorName, majorName, queryIsConfirm, isConfirm, pageSize, pageNo);
            pm.setPageNav(request.getRequestURI());
            request.setAttribute("pm", pm);
        }
        request.getRequestDispatcher("/admin/infomanage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        request(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request(request, response);
    }
}
