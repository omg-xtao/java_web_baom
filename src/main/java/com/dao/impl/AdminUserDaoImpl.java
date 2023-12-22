package com.dao.impl;

import com.dao.AdminUserDao;
import com.db.ConnectionFactory;
import com.entity.AdminUser;
import com.entity.mapper.AdminUserMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.ArrayList;

import static com.entity.table.AdminUserTableDef.ADMIN_USER;

/**
 * @author xtaod
 */
public class AdminUserDaoImpl implements AdminUserDao {
    private static final AdminUserMapper mapper = ConnectionFactory.getMapper(AdminUserMapper.class);

    @Override
    public AdminUser validateLogin(String username, String password) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(ADMIN_USER.ALL_COLUMNS)
                .where(ADMIN_USER.ADMINNAME.eq(username))
                .and(ADMIN_USER.ADMINPASS.eq(password));
        return mapper.selectOneByQuery(qw);
    }

    @Override
    public ArrayList<AdminUser> findAll() {
        QueryWrapper qw = new QueryWrapper();
        qw.select(ADMIN_USER.ALL_COLUMNS);
        return (ArrayList<AdminUser>) mapper.selectListByQuery(qw);
    }

    @Override
    public AdminUser findByAdminname(String adminname) {
        QueryWrapper qw = new QueryWrapper();
        qw.select(ADMIN_USER.ALL_COLUMNS)
                .where(ADMIN_USER.ADMINNAME.eq(adminname));
        return mapper.selectOneByQuery(qw);
    }

    @Override
    public int deleteByAdminname(String adminname) {
        QueryWrapper qw = new QueryWrapper();
        qw.where(ADMIN_USER.ADMINNAME.eq(adminname));
        return mapper.deleteByQuery(qw);
    }

    @Override
    public int passModify(String adminname, String adminpass) {
        AdminUser user = findByAdminname(adminname);
        if (user == null) {
            return 0;
        }
        user.setAdminpass(adminpass);
        return mapper.update(user);
    }

    @Override
    public int add(AdminUser adminUser) {
        return mapper.insert(adminUser);
    }
}
