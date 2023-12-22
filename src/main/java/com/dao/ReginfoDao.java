package com.dao;

import com.entity.Reginfo;

/**
 * @author xtaod
 */
public interface ReginfoDao {
    int add(Reginfo reginfo);
    int update(Reginfo reginfo);
    Reginfo findByUser(String username);
}
