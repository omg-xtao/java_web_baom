package com.dao;

import com.entity.Record;
import com.util.PageModel;

/**
 * @author xtaod
 */
public interface RecordDao {
    int add(Record record);

    PageModel pageByLogname(String logname, String group, int pageSize, int pageNo);
}
