package com.dao;

import com.entity.Grade;

import java.util.ArrayList;

/**
 * @author xtaod
 */
public interface GradeDao {
    int add(Grade grade);

    int update(Grade grade);

    ArrayList<Grade> queryAll();

    Grade findByTestcardnumAndCname(String testCardNum, String cName);
}
