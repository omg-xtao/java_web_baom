package com.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.sql.Timestamp;

/**
 * @author xtaod
 */
@Table(value = "stage", dataSource = "eers")
public class Stage {
    @Id(keyType = KeyType.None)
    private int stagenum;
    private String stagename;
    private Timestamp starttime;
    private Timestamp endtime;
    private String note;

    public int getStagenum() {
        return stagenum;
    }

    public void setStagenum(int stagenum) {
        this.stagenum = stagenum;
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
