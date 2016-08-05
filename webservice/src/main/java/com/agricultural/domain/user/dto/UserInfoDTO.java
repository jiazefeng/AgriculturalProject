package com.agricultural.domain.user.dto;

import com.agricultural.hibernate.BaseVO;

/**
 * Created by maxrocky on 2016/08/05.
 */
public class UserInfoDTO extends BaseVO {
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

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuRealName() {
        return uRealName;
    }

    public void setuRealName(String uRealName) {
        this.uRealName = uRealName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public int getuState() {
        return uState;
    }

    public void setuState(int uState) {
        this.uState = uState;
    }

    public String getuHendImg() {
        return uHendImg;
    }

    public void setuHendImg(String uHendImg) {
        this.uHendImg = uHendImg;
    }
}
