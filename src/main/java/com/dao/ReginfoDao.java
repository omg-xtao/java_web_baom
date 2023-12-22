package com.dao;

import com.entity.Reginfo;
import com.util.PageModel;

/**
 * @author xtaod
 */
public interface ReginfoDao {
    int add(Reginfo reginfo);

    int update(Reginfo reginfo);

    Reginfo findByUser(String username);

    PageModel pageByMajorName(boolean queryMajorName, String majorName, boolean queryIsConfirm, Boolean isConfirm, int pageSize, int pageNo);
}
