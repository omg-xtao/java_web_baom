package com.entity;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.sql.Timestamp;

/**
 * @author xtaod
 */
@Table(value = "currstage", dataSource="eers")
public class CurrStage {
    @Id(keyType = KeyType.Auto)
    private int configid;
    private String adminname;
    @Column(onInsertValue = "now()")
    private Timestamp settime;
    private String stagename;

    public int getConfigid() {
        return configid;
    }

    public void setConfigid(int configid) {
        this.configid = configid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public Timestamp getSettime() {
        return settime;
    }

    public void setSettime(Timestamp settime) {
        this.settime = settime;
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename;
    }
}
