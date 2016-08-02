package com.agricultural.domain.user.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * 用户信息
 * Created by jiazefeng on 2016/08/01.
 */
@Entity
@Table(name = "USER_INFO")
public class UserInfo extends BaseVO {
    /**
     * 用户ID
     */
    private String uId;
    /**
     * 用户名
     */
    private String uName;
    /**
     * 用户真实姓名
     */
    private String uRealName;
    /**
     * 用户密码
     */
    private String uPwd;
    /**
     * 用户手机
     */
    private String phone;
    /**
     * 个人简介
     */
    private String personalProfile;
    /**
     * 状态
     */
    private int uState;
    /**
     * 用户头像
     */
    private String uHendImg;

    @Id
    @Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, insertable = true, updatable = true, length = 64)
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "USER_REAL_NAME", nullable = true, insertable = true, updatable = true, length = 64)
    public String getuRealName() {
        return uRealName;
    }

    public void setuRealName(String uRealName) {
        this.uRealName = uRealName;
    }

    @Basic
    @Column(name = "USER_PWD", nullable = true, insertable = true, updatable = true, length = 64)
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Basic
    @Column(name = "USER_PHONE", nullable = true, insertable = true, updatable = true, length = 32)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "USER_PersonalProfile", nullable = true, insertable = true, updatable = true, length = 500)
    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    @Basic
    @Column(name = "USER_STATE", nullable = true, insertable = true, updatable = true, length = 2)
    public int getuState() {
        return uState;
    }

    public void setuState(int uState) {
        this.uState = uState;
    }

    @Basic
    @Column(name = "USER_headImg", nullable = true, insertable = true, updatable = true, length = 64)
    public String getuHendImg() {
        return uHendImg;
    }

    public void setuHendImg(String uHendImg) {
        this.uHendImg = uHendImg;
    }
}
