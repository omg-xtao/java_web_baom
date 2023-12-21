package com.servlet;

import com.dao.AdminUserDao;
import com.dao.impl.AdminUserDaoImpl;
import com.entity.AdminUser;
import com.util.Encrypt;

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
@WebServlet("/admin/pass.do")
public class AdminPass extends HttpServlet {
    String jspPath = "/admin/pass.jsp";

    private void forward(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("adminPassMess", message);
        request.getRequestDispatcher(jspPath).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AdminUserDao adminUserDao = new AdminUserDaoImpl();
        AdminUser user = (AdminUser) session.getAttribute("adminuser");
        String oldPassword = request.getParameter("oldPassword");
        String password = request.getParameter("password");
        String confirmpass = request.getParameter("confirmpass");
        String code = request.getParameter("code");
        String mess = validateForm(oldPassword, password, confirmpass, code);
        if (!mess.isEmpty()) {
            forward(request, response, mess);
            return;
        }
        AdminUser s = adminUserDao.validateLogin(user.getAdminname(), Encrypt.SHA(oldPassword));
        if (s == null) {
            forward(request, response, "* 旧密码错误！");
            return;
        }
        if (adminUserDao.passModify(user.getAdminname(), Encrypt.SHA(password)) != 0) {
            forward(request, response, "* 密码修改成功！");
        } else {
            forward(request, response, "* 密码修改失败！");
        }
    }

    private String validateForm(String oldPassword, String password, String confirmpass, String code) {
        if (password == null || !password.matches("\\w{6,20}")) {
            return "* 密码不合法！";
        } else if (!password.equals(confirmpass)) {
            return "* 两次输入的密码不一致，请重新输入！";
        } else if (oldPassword == null || password.equals(oldPassword)) {
            return "* 新密码不能与旧密码相同！";
        } else if (code == null || !code.matches("\\d{4}")) {
            return "* 验证码错误！";
        }
        return "";
    }
}
