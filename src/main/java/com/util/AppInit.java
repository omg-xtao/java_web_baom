package com.util;

import com.dao.*;
import com.dao.impl.*;

import javax.servlet.ServletContext;

/**
 * @author xtaod
 */
public class AppInit {
    public static void initStage(ServletContext servletContext) {
        StageDao stageDao = new StageDaoImpl();
        servletContext.setAttribute("stages", stageDao.findAll());
        CurrStageDao currStageDao = new CurrStageDaoImpl();
        servletContext.setAttribute("currstage", currStageDao.findCurrent());
    }

    public static void initSchool(ServletContext servletContext) {
        SchoolDao schoolDao = new SchoolDaoImpl();
        servletContext.setAttribute("school", schoolDao.getSchool());
    }

    public static void initMajor(ServletContext servletContext) {
        MajorDao majorDao = new MajorDaoImpl();
        servletContext.setAttribute("majors", majorDao.findAll());
    }

    public static void initCourse(ServletContext servletContext) {
        CourseDao courseDao = new CourseDaoImpl();
        servletContext.setAttribute("courses", courseDao.findAll());
    }
}
