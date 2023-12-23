package com.entity;


import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.sql.Timestamp;

/**
 * @author xtaod
 */
@Table(value = "course", dataSource = "eers")
public class Course {
    @Id(keyType = KeyType.None)
    private int ccode;
    private String cname;
    private String cmname;
    private Timestamp cstarttime;
    private Timestamp cendtime;

    public int getCcode() {
        return ccode;
    }

    public void setCcode(int ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname;
    }

    public Timestamp getCstarttime() {
        return cstarttime;
    }

    public void setCstarttime(Timestamp cstarttime) {
        this.cstarttime = cstarttime;
    }

    public Timestamp getCendtime() {
        return cendtime;
    }

    public void setCendtime(Timestamp cendtime) {
        this.cendtime = cendtime;
    }
}
