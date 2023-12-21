package com.dao;

import com.entity.CurrStage;

/**
 * @author xtaod
 */
public interface CurrStageDao {
    int set(String adminname,String currstage);
    CurrStage findCurrent();
}
