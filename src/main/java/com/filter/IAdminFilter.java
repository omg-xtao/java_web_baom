package com.filter;

import com.entity.AdminUser;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xtaod
 */
public class IAdminFilter {
    public void doAdminFilter(
            ServletRequest request, ServletResponse response, FilterChain chain, String groupName
    ) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("adminuser") != null) {
            AdminUser adminuser = (AdminUser) session.getAttribute("adminuser");
            if (groupName.equals(adminuser.getAdmingroup()) || groupName.isEmpty()) {
                chain.doFilter(request, response);
            } else {
                req.setAttribute("adminLoginMess", "*您不是" + groupName + "，无法访问！");
                req.getRequestDispatcher("/manage.jsp").forward(request, response);
            }
        } else {
            req.setAttribute("adminLoginMess", "*请先登录！");
            req.getRequestDispatcher("/manage.jsp").forward(request, response);
        }
    }
}
