package com.servlet;

import com.dao.AdminUserDao;
import com.dao.RecordDao;
import com.dao.impl.AdminUserDaoImpl;
import com.dao.impl.RecordDaoImpl;
import com.entity.AdminUser;
import com.entity.Record;
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
@WebServlet("/adminLogin.do")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        AdminUserDao adminUserDao = new AdminUserDaoImpl();
        RecordDao recordDao = new RecordDaoImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("code", code);
        String mess = validateForm(username, password, code);
        if (!mess.isEmpty()){
            request.setAttribute("adminLoginMess", mess);
            request.getRequestDispatcher("/manage.jsp").forward(request, response);
        }else {
            String sessioncode = session.getAttribute("sessioncode").toString();
            if (!code.equals(sessioncode)) {
                request.setAttribute("adminLoginMess", "* 验证码错误！");
                request.getRequestDispatcher("/manage.jsp").forward(request, response);
                return;
            }
            AdminUser user = adminUserDao.validateLogin(username, Encrypt.SHA(password));
            if (user == null) {
                request.setAttribute("adminLoginMess", "* 用户名或密码输入错误！");
                request.getRequestDispatcher("/manage.jsp").forward(request, response);
            }else {
                Record record = new Record();
                record.setLogname(username);
                record.setUsergroup(user.getAdmingroup());
                record.setLogip(request.getRemoteAddr());
                if (recordDao.add(record) != 0) {
                    session.setAttribute("adminuser", user);
                    response.sendRedirect(request.getContextPath() + "/admin/state.jsp");
                } else {
                    request.setAttribute("adminLoginMess", "* 登录异常！");
                    request.getRequestDispatcher("/manage.jsp").forward(request, response);
                }
            }
        }
    }

    private String validateForm(String username, String password, String code) {
        if (username == null || !username.matches("\\w{6,20}")) {
            return "* 用户名不合法！";
        } else if (password == null || !password.matches("\\w{6,20}")) {
            return "* 密码不合法！";
        } else if (code == null || !code.matches("\\d{4}")) {
            return "* 验证码错误！";
        }
        return "";
    }
}
