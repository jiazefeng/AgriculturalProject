package com.agricultural.domain.user.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * Created by jiazefeng on 2016/08/01.
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRole extends BaseVO {
    private String urId;
    private String userId;
    private String roleId;

    @Id
    @Column(name = "USER_ROLE_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getUrId() {
        return urId;
    }

    public void setUrId(String urId) {
        this.urId = urId;
    }

    @Basic
    @Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
