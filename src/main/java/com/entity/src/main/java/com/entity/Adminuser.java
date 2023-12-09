package com.entity;

import java.io.Serializable;

/**
 * adminuser
 * @author 
 */
public class Adminuser implements Serializable {
    /**
     * //管理员id
     */
    private Integer adminid;

    /**
     * //管理员用户名
     */
    private String adminname;

    /**
     * //密码
     */
    private String adminpass;

    /**
     * //所在组
     */
    private String admingroup;

    private static final long serialVersionUID = 1L;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Adminuser other = (Adminuser) that;
        return (this.getAdminid() == null ? other.getAdminid() == null : this.getAdminid().equals(other.getAdminid()))
            && (this.getAdminname() == null ? other.getAdminname() == null : this.getAdminname().equals(other.getAdminname()))
            && (this.getAdminpass() == null ? other.getAdminpass() == null : this.getAdminpass().equals(other.getAdminpass()))
            && (this.getAdmingroup() == null ? other.getAdmingroup() == null : this.getAdmingroup().equals(other.getAdmingroup()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminid() == null) ? 0 : getAdminid().hashCode());
        result = prime * result + ((getAdminname() == null) ? 0 : getAdminname().hashCode());
        result = prime * result + ((getAdminpass() == null) ? 0 : getAdminpass().hashCode());
        result = prime * result + ((getAdmingroup() == null) ? 0 : getAdmingroup().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminid=").append(adminid);
        sb.append(", adminname=").append(adminname);
        sb.append(", adminpass=").append(adminpass);
        sb.append(", admingroup=").append(admingroup);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}