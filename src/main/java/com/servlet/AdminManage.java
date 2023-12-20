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
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author xtaod
 */
@WebServlet("/sadmin/manage.do")
public class AdminManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        AdminUserDao adminuserDao = new AdminUserDaoImpl();
        String action = request.getParameter("action");
        if (action == null || action.isEmpty() || "findAll".equals(action)) {
            findAll(adminuserDao, request, response);
        } else if ("deleteByAdminname".equals(action)) {
            deleteByAdminname(adminuserDao, request, response);
        } else if ("passReset".equals(action)) {
            passReset(adminuserDao, request, response);
        }
    }

    private void findAll(AdminUserDao adminuserDao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<AdminUser> adminusers = adminuserDao.findAll();
        request.setAttribute("adminusers", adminusers);
        request.getRequestDispatcher("/sadmin/manage.jsp").forward(request, response);
    }

    private void add(AdminUserDao adminuserDao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        String adminpass = request.getParameter("adminpass");
        String admingroup = request.getParameter("admingroup");
        AdminUser adminuser = new AdminUser();
        adminuser.setAdminname(adminname);
        adminuser.setAdminpass(Encrypt.SHA(adminpass));
        adminuser.setAdmingroup(admingroup);
        request.setAttribute("newadmin", adminuser);
        String mess = validateForm(adminname, adminpass, admingroup);
        if (!mess.isEmpty()) {
            request.setAttribute("addMess", mess);
        } else {
            if (adminuserDao.findByAdminname(adminname) != null) {
                request.setAttribute("addMess", "* 用户名已存在！");
            } else if (adminuserDao.add(adminuser) != 0) {
                request.removeAttribute("newadmin");
                request.setAttribute("addMess", "* 添加新管理员成功！");
            } else {
                request.setAttribute("addMess", "* 添加新管理员失败！");
            }
        }
        request.getRequestDispatcher("/sadmin/manage.do?action=findAll").forward(request, response);
    }

    private void deleteByAdminname(AdminUserDao adminuserDao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        if ("系统管理员".equals(adminuserDao.findByAdminname(adminname).getAdmingroup())) {
            request.setAttribute("manageMess", "* 不能删除系统管理员！");
        } else if (adminuserDao.deleteByAdminname(adminname) != 0) {
            request.setAttribute("manageMess", "* 删除管理员成功！");
        } else {
            request.setAttribute("manageMess", "* 删除管理员失败！");
        }
        request.getRequestDispatcher("/sadmin/manage.do?action=findAll").forward(request, response);
    }

    private void passReset(AdminUserDao adminuserDao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        if (adminuserDao.passModify(adminname, Encrypt.SHA("000000")) != 0) {
            request.setAttribute("manageMess", "* 管理员密码清零成功！");
        } else {
            request.setAttribute("manageMess", "* 管理员密码清零失败！");
        }
        request.getRequestDispatcher("/sadmin/manage.do?action=findAll").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        AdminUserDao adminuserDao = new AdminUserDaoImpl();
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            add(adminuserDao, request, response);
        } else if ("findAll".equals(action)) {
            findAll(adminuserDao, request, response);
        }
    }

    private String validateForm(String username, String password, String group) {
        if (username == null || !username.matches("\\w{6,20}")) {
            return "* 用户名不合法！";
        } else if (password == null || !password.matches("\\w{6,20}")) {
            return "* 密码不合法！";
        } else if (!("系统管理员".equals(group) || "招生管理员".equals(group) || "教务管理员".equals(group))) {
            return "* 管理组错误！";
        }
        return "";
    }
}
