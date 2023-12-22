package com.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xtaod
 */
public class HttpServletInit extends HttpServlet {
    public void initStage(HttpServletRequest request) {
        AppInit.initStage(request.getServletContext());
    }

    public void initSchool(HttpServletRequest request) {
        AppInit.initSchool(request.getServletContext());
    }

    public void initMajor(HttpServletRequest request) {
        AppInit.initMajor(request.getServletContext());
    }

    public void initCourse(HttpServletRequest request) {
        AppInit.initCourse(request.getServletContext());
    }
}
