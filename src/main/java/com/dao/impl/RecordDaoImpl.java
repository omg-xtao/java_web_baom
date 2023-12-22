package com.dao.impl;

import com.dao.RecordDao;
import com.db.ConnectionFactory;
import com.entity.Record;
import com.entity.mapper.RecordMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.util.PageModel;

import java.util.List;

import static com.entity.table.RecordTableDef.RECORD;

/**
 * @author xtaod
 */
public class RecordDaoImpl implements RecordDao {
    private static final RecordMapper mapper = ConnectionFactory.getMapper(RecordMapper.class);

    @Override
    public int add(Record stu) {
        return mapper.insert(stu);
    }

    @Override
    public PageModel pageByLogname(String logname, String group, int pageSize, int pageNo) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(RECORD.ALL_COLUMNS)
                .where(RECORD.LOGNAME.eq(logname))
                .where(RECORD.USERGROUP.eq(group));
        List<Record> recordsList = mapper.selectListByQuery(qw);
        return new PageModel(pageSize, pageNo, recordsList);
    }
}
