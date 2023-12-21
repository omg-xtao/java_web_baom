package com.dao;

import com.entity.School;

/**
 * @author xtaod
 */
public interface SchoolDao {
    int add(School school);

    School getSchool();
}
