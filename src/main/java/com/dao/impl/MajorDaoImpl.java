package com.dao.impl;

import com.dao.MajorDao;
import com.db.ConnectionFactory;
import com.entity.Major;
import com.entity.mapper.MajorMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.ArrayList;

import static com.entity.table.MajorTableDef.MAJOR;

/**
 * @author xtaod
 */
public class MajorDaoImpl implements MajorDao {
    private static final MajorMapper mapper = ConnectionFactory.getMapper(MajorMapper.class);

    @Override
    public int add(Major major) {
        return mapper.insert(major);
    }

    @Override
    public int deleteByMcode(String mcode) {
        QueryWrapper qw = new QueryWrapper();
        qw.where(MAJOR.MCODE.eq(mcode));
        return mapper.deleteByQuery(qw);
    }

    @Override
    public ArrayList<Major> findAll() {
        QueryWrapper qw = new QueryWrapper();
        qw.select(MAJOR.ALL_COLUMNS);
        return (ArrayList<Major>) mapper.selectListByQuery(qw);
    }

    @Override
    public Major findByMcode(String mcode) {
        QueryWrapper qw = new QueryWrapper();
        qw.where(MAJOR.MCODE.eq(mcode));
        return mapper.selectOneByQuery(qw);
    }
}
