package com.listener;

import com.dao.*;
import com.dao.impl.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author xtaod
 */
public class MyServletContextListener implements ServletContextListener {
    public void initStage(ServletContext servletContext) {
        StageDao stageDao = new StageDaoImpl();
        servletContext.setAttribute("stages", stageDao.findAll());
        CurrStageDao currStageDao = new CurrStageDaoImpl();
        servletContext.setAttribute("currstage", currStageDao.findCurrent());
    }

    public void initSchool(ServletContext servletContext) {
        SchoolDao schoolDao = new SchoolDaoImpl();
        servletContext.setAttribute("school", schoolDao.getSchool());
    }

    public void initMajor(ServletContext servletContext) {
        MajorDao majorDao = new MajorDaoImpl();
        servletContext.setAttribute("majors", majorDao.findAll());
    }

    public void initCourse(ServletContext servletContext) {
        CourseDao courseDao = new CourseDaoImpl();
        servletContext.setAttribute("courses", courseDao.findAll());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        initStage(context);
        initSchool(context);
        initMajor(context);
        initCourse(context);
    }
}
