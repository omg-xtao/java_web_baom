package com.dao.impl;

import com.dao.SchoolDao;
import com.db.ConnectionFactory;
import com.entity.School;
import com.entity.mapper.SchoolMapper;
import com.mybatisflex.core.query.QueryWrapper;

import static com.entity.table.SchoolTableDef.SCHOOL;

/**
 * @author xtaod
 */
public class SchoolDaoImpl implements SchoolDao {
    private static final SchoolMapper mapper = ConnectionFactory.getMapper(SchoolMapper.class);

    @Override
    public int add(School school) {
        return mapper.insert(school);
    }

    @Override
    public School getSchool() {
        QueryWrapper qw = new QueryWrapper();
        qw.select(SCHOOL.ALL_COLUMNS).orderBy(SCHOOL.SHID.desc()).limit(1);
        return mapper.selectOneByQuery(qw);
    }
}
