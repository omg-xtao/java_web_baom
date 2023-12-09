package com.dao.impl;

import com.dao.StuDao;
import com.db.ConnectionFactory;
import com.entity.Stu;
import com.entity.mapper.StuMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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
        return null;
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
