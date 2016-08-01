package com.agricultural.domain.role.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * Created by JIAZEFENG on 2016/08/01.
 */
@Entity
@Table(name = "ROLE_FUNCTION")
public class RoleFunction extends BaseVO {
    private String rfId;
    private String roleId;
    private String funcId;

    @Id
    @Column(name = "ROLE_FUNCTION_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getRfId() {
        return rfId;
    }

    public void setRfId(String rfId) {
        this.rfId = rfId;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "FUNCTION_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }
}
