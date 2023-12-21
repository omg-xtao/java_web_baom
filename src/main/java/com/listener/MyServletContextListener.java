package com.listener;

import com.dao.CurrStageDao;
import com.dao.StageDao;
import com.dao.impl.CurrStageDaoImpl;
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

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initStage(sce.getServletContext());
    }
}
