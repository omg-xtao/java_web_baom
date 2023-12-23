package com.entity;

/**
 * @author xtaod
 */
public class GradeVo {
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

    private Reginfo reginfo;

    public Integer getGradeid() {
        return gradeid;
    }

    public String getTestcardnum() {
        return testcardnum;
    }

    public String getSname() {
        return sname;
    }

    public String getCname() {
        return cname;
    }

    public Float getScore() {
        return score;
    }

    public String getNote() {
        return note;
    }

    public Reginfo getReginfo() {
        return reginfo;
    }
}
