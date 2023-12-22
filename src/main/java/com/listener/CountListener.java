package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionListener;

/**
 * @author xtaod
 */
public class CountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(javax.servlet.http.HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        if (context.getAttribute("count") == null) {
            Integer count = 1;
            context.setAttribute("count", count);
        } else {
            Integer count = (Integer) context.getAttribute("count");
            context.setAttribute("count", count + 1);
        }
        se.getSession().setAttribute("username", "mrwangzhe");
    }

    @Override
    public void sessionDestroyed(javax.servlet.http.HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("count");
        context.setAttribute("count", count - 1);
    }
}
