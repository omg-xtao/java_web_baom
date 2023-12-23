package com.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.sql.Date;

/**
 * @author xtaod
 */
@Table(value = "reginfo", dataSource = "eers")
public class Reginfo {
    /**
     * 信息表id
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 注册用户id
     */
    private Integer userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 学生姓名
     */
    private String sname;

    /**
     * 身份证号
     */
    private String idcode;

    /**
     * 性别
     */
    private String ssex;

    /**
     * 是否确认
     */
    private Boolean isconfirm;

    /**
     * 准考证号
     */
    private String testcardnum;

    /**
     * 考场号
     */
    private String examroom;

    /**
     * 座位号
     */
    private Integer seatnum;

    /**
     * 民族
     */
    private String nation;

    /**
     * 政治面貌
     */
    private String political;

    /**
     * 家庭住址
     */
    private String homeaddr;

    /**
     * 生源地
     */
    private String source;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 毕业时间
     */
    private Date gradutetime;

    /**
     * 是否应届
     */
    private Boolean isnew;

    /**
     * 文理科
     */
    private String aos;

    /**
     * 所学专业
     */
    private String major;

    /**
     * 英语46级
     */
    private String cet;

    /**
     * 报考专业
     */
    private String mname;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 联系电话
     */
    private String telphone;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 联系地址
     */
    private String conaddr;

    /**
     * 接收人
     */
    private String receiver;

    /**
     * 照片位置
     */
    private String photo;

    /**
     * 是否录取
     */
    private Boolean isadmit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Boolean getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(Boolean isconfirm) {
        this.isconfirm = isconfirm;
    }

    public String getTestcardnum() {
        return testcardnum;
    }

    public void setTestcardnum(String testcardnum) {
        this.testcardnum = testcardnum;
    }

    public String getExamroom() {
        return examroom;
    }

    public void setExamroom(String examroom) {
        this.examroom = examroom;
    }

    public Integer getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(Integer seatnum) {
        this.seatnum = seatnum;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getHomeaddr() {
        return homeaddr;
    }

    public void setHomeaddr(String homeaddr) {
        this.homeaddr = homeaddr;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getGradutetime() {
        return gradutetime;
    }

    public void setGradutetime(Date gradutetime) {
        this.gradutetime = gradutetime;
    }

    public Boolean getIsnew() {
        return isnew;
    }

    public void setIsnew(Boolean isnew) {
        this.isnew = isnew;
    }

    public String getAos() {
        return aos;
    }

    public void setAos(String aos) {
        this.aos = aos;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCet() {
        return cet;
    }

    public void setCet(String cet) {
        this.cet = cet;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getConaddr() {
        return conaddr;
    }

    public void setConaddr(String conaddr) {
        this.conaddr = conaddr;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getIsadmit() {
        return isadmit;
    }

    public void setIsadmit(Boolean isadmit) {
        this.isadmit = isadmit;
    }
}