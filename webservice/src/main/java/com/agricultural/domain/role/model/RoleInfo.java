package com.agricultural.domain.role.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * 角色信息
 * <p>
 * Created by jiazefeng on 2016/08/01.
 */
@Entity
@Table(name = "role_info")
public class RoleInfo extends BaseVO {
    /**
     * 角色ID
     */
    private String rId;
    /**
     * 角色名称
     */
    private String rName;
    /**
     * 角色启用状态：0：停用；1：启用
     */
    private int rState;

    @Id
    @Column(name = "ROLE_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = true, insertable = true, updatable = true, length = 64)
    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    @Basic
    @Column(name = "ROLE_STATE", nullable = true, insertable = true, updatable = true, length = 11)
    public int getrState() {
        return rState;
    }

    public void setrState(int rState) {
        this.rState = rState;
    }
}
