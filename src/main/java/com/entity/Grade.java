package com.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

/**
 * @author xtaod
 */
@Table(value = "grade", dataSource = "eers")
public class Grade {
    @Id(keyType = KeyType.Auto)
    private Integer gradeid;

    /**
     * 准考证号
     */
    private String testcardnum;

    /**
     * 考生姓名
     */
    private String sname;

    /**
     * 考试科目
     */
    private String cname;

    /**
     * 成绩
     */
    private Float score;

    /**
     * 备注
     */
    private String note;

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getTestcardnum() {
        return testcardnum;
    }

    public void setTestcardnum(String testcardnum) {
        this.testcardnum = testcardnum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}