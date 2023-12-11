package com.dao;

import com.entity.Record;
import com.util.PageModel;

/**
 * @author xtaod
 */
public interface RecordDao {
    int add(Record record);
    PageModel<Record> pageByLogname(String logname, String usergroup, int pageSize, int pageNo);
}
