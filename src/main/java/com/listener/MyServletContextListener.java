package com.listener;

import com.util.AppInit;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author xtaod
 */
public class MyServletContextListener extends AppInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        initStage(context);
        initSchool(context);
        initMajor(context);
        initCourse(context);
    }
}
