package com.dao;

import com.entity.Grade;
import com.entity.GradeVo;

import java.util.ArrayList;

/**
 * @author xtaod
 */
public interface GradeDao {
    int add(Grade grade);

    int update(Grade grade);

    ArrayList<Grade> queryAll();

    Grade findByTestcardnumAndCname(String testCardNum, String cName);

    ArrayList<Grade> findByTestcardnum(String testCardNum);

    ArrayList<Grade> findBySname(String sname);

    ArrayList<GradeVo> findByMName(String mName);
}
