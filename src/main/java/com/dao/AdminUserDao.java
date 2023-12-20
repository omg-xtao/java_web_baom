package com.dao;

import com.entity.AdminUser;

/**
 * @author xtaod
 */
public interface AdminUserDao {
    AdminUser validateLogin(String username, String password);
}
