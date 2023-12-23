package com.servlet;

import com.dao.ReginfoDao;
import com.dao.impl.ReginfoDaoImpl;
import com.util.HttpServletInit;
import com.util.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xtaod
 */
@WebServlet("/zadmin/confirm.do")
public class ZAdminConfirm extends HttpServletInit {
    private void getReginfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCode = request.getParameter("idCode");
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        request.setAttribute("reginfos", reginfoDao.findByIdCode(idCode));
        request.getRequestDispatcher("/zadmin/confirm.jsp").forward(request, response);
    }

    private void confirmReginfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        int result = reginfoDao.confirmByUserName(username);
        if (result == 0) {
            request.getSession().setAttribute("mess", new Message("confirmMess", "确认失败！"));
        } else {
            request.getSession().setAttribute("mess", new Message("confirmMess", "确认成功！"));
        }
        getReginfo(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String confirm = req.getParameter("confirm");
        if (confirm == null || confirm.isEmpty()) {
            getReginfo(req, resp);
        } else {
            confirmReginfo(req, resp);
        }
    }
}
