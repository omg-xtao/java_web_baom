package com.dao;

import com.entity.AdminUser;

import java.util.ArrayList;

/**
 * @author xtaod
 */
public interface AdminUserDao {
    AdminUser validateLogin(String username, String password);

    ArrayList<AdminUser> findAll();

    AdminUser findByAdminname(String adminname);

    int deleteByAdminname(String adminname);

    int passModify(String adminname, String adminpass);

    int add(AdminUser adminUser);
}
