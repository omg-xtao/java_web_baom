package com.dao.impl;

import com.dao.AdminUserDao;
import com.db.ConnectionFactory;
import com.entity.AdminUser;
import com.entity.mapper.AdminUserMapper;
import com.mybatisflex.core.query.QueryWrapper;

import static com.entity.table.AdminUserTableDef.ADMIN_USER;

/**
 * @author xtaod
 */
public class AdminUserDaoImpl implements AdminUserDao {
    private static AdminUserMapper mapper = null;

    public AdminUserDaoImpl() {
        mapper = ConnectionFactory.getMapper(AdminUserMapper.class);
    }

    @Override
    public AdminUser validateLogin(String username, String password) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(ADMIN_USER.ALL_COLUMNS)
                .where(ADMIN_USER.ADMINNAME.eq(username))
                .and(ADMIN_USER.ADMINPASS.eq(password));
        return mapper.selectOneByQuery(qw);
    }
}
