package com.servlet;

import com.dao.StuDao;
import com.dao.impl.StuDaoImpl;
import com.entity.Stu;
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
@WebServlet("/StuPass")
public class StuPass extends HttpServlet {
    String jspPath = "/stu/pass.jsp";

    private void forward(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("stuPassMess", message);
        request.getRequestDispatcher(jspPath).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StuDao stuDao = new StuDaoImpl();
        String username = (String) session.getAttribute("username");
        String oldPassword = request.getParameter("oldPassword");
        String password = request.getParameter("password");
        String confirmpass = request.getParameter("confirmpass");
        String code = request.getParameter("code");
        String mess = validateForm(oldPassword, password, confirmpass, code);
        if (!mess.isEmpty()) {
            forward(request, response, mess);
            return;
        }
        String sessioncode = session.getAttribute("sessioncode").toString();
        if (!code.equals(sessioncode)) {
            forward(request, response, "* 验证码错误！");
            return;
        }
        Stu s = stuDao.validateLogin(username, Encrypt.SHA(oldPassword));
        if (s == null) {
            forward(request, response, "* 旧密码错误！");
            return;
        }
        if (stuDao.passModify(username, Encrypt.SHA(password)) != 0) {
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
