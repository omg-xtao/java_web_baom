package com.dao.impl;

import com.dao.StuDao;
import com.db.ConnectionFactory;
import com.entity.Stu;
import com.entity.mapper.StuMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.ArrayList;

import static com.entity.table.StuTableDef.STU;

/**
 * @author xtaod
 */
public class StuDaoImpl implements StuDao {
    private static StuMapper mapper = null;

    public StuDaoImpl() {
        mapper = ConnectionFactory.getMapper(StuMapper.class);
    }

    @Override
    public int add(Stu stu) {
        return mapper.insert(stu);
    }

    @Override
    public Stu findByUsername(String username) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(STU.ALL_COLUMNS)
                .where(STU.USERNAME.eq(username));
        return mapper.selectOneByQuery(qw);
    }

    @Override
    public Stu validateLogin(String username, String password) {
        return null;
    }

    @Override
    public int passModify(String username, String newpass) {
        return 0;
    }

    @Override
    public ArrayList<Stu> findStusLikeUsername(String username) {
        return null;
    }

    @Override
    public ArrayList<Stu> findStusLikeIdcode(String idcode) {
        return null;
    }
}
