package com.dao;

import com.entity.Major;

import java.util.ArrayList;

/**
 * @author xtaod
 */
public interface MajorDao {
    int add(Major major);

    int update(Major major);

    int deleteByMcode(String mcode);

    ArrayList<Major> findAll();

    Major findByMcode(String mcode);
}
