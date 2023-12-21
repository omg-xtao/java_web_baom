package com.listener;

import com.dao.CurrStageDao;
import com.dao.MajorDao;
import com.dao.SchoolDao;
import com.dao.StageDao;
import com.dao.impl.CurrStageDaoImpl;
import com.dao.impl.MajorDaoImpl;
import com.dao.impl.SchoolDaoImpl;
import com.dao.impl.StageDaoImpl;

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

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        initStage(context);
        initSchool(context);
        initMajor(context);
    }
}
