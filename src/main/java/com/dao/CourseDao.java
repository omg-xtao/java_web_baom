package com.dao;

import com.entity.Course;

import java.util.ArrayList;

/**
 * @author xtaod
 */
public interface CourseDao {
    int add(Course course);

    int deleteByCcode(String ccode);

    ArrayList<Course> findAll();

    Course findByCcode(String ccode);

    ArrayList<Course> findByCmname(String cmname);
}
