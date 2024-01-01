package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author xtaod
 */
public class FileFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        String reqPath = req.getServletPath();
        ArrayList<String> allowPath = new ArrayList<>();
        allowPath.add("/upload/" + session.getAttribute("username") + ".jpg");
        allowPath.add("/upload/zkz/" + session.getAttribute("username") + ".pdf");
        allowPath.add("/upload/baom/" + session.getAttribute("username") + ".pdf");

        if (allowPath.contains(reqPath)) {
            chain.doFilter(request, response);
        } else {
            req.setAttribute("Mess", "* 非法访问");
            req.getRequestDispatcher("/stu/notice.jsp").forward(request, response);
        }
    }
}
