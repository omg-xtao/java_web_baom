package com.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

/**
 * @author xtaod
 */
@Table(value = "adminuser", dataSource = "eers")
public class AdminUser {
    @Id(keyType = KeyType.Auto)
    private int adminid;    //用户ID

    private String adminname;    //用户名
    private String adminpass;    //密码
    private String admingroup;   //用户组

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpass() {
        return adminpass;
    }

    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass;
    }

    public String getAdmingroup() {
        return admingroup;
    }

    public void setAdmingroup(String admingroup) {
        this.admingroup = admingroup;
    }
}
