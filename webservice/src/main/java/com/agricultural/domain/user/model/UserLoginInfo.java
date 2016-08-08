package com.agricultural.domain.user.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jiazefeng on 2016/08/08.
 */
@Entity
@Table(name = "USER_LOGIN_INFO")
public class UserLoginInfo extends BaseVO {
    /**
     * 用户登录唯一标示
     */
    private String tokenId;
    /**
     * 用户登录类型
     */
    private String loginType;
    /**
     * 用户登录时间
     */
    private Date makeDate;
    /**
     * 用户ID
     */
    private String userId;

    @Id
    @Column(name = "TookenId", nullable = false, insertable = true, updatable = true, length = 50)
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }


    @Basic
    @Column(name = "LoginType", nullable = false, insertable = true, updatable = true, length = 20)
    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Basic
    @Column(name = "MakeDate", nullable = true, insertable = true, updatable = true)
    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }


    @Basic
    @Column(name = "UserId", nullable = true, insertable = true, updatable = true, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
