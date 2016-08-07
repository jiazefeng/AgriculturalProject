package com.agricultural.domain.user.dto;

/**
 * Created by maxrocky on 2016/08/06.
 */
public class UserInfoListDTO {
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
     * 用户手机
     */
    private String phone;
    /**
     * 个人简介
     */
    private String personalProfile;
    /**
     * 角色名称
     */
    private String roleName;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
