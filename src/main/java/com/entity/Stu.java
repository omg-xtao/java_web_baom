package com.entity;

import com.mybatisflex.annotation.*;

import java.sql.Timestamp;

/**
 * @author xtaod
 */
@Table(value = "stu", dataSource="eers")
public class Stu {

    @Id(keyType = KeyType.Auto)
    private int userid;    //用户ID

    private String username;    //用户名
    private String password;    //密码
    private String regip;    //注册IP

    @Column(onInsertValue = "now()")
    private Timestamp regtime;    //注册时间

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegip() {
        return regip;
    }

    public void setRegip(String regip) {
        this.regip = regip;
    }

    public Timestamp getRegtime() {
        return regtime;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }
}
