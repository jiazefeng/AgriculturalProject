package com.agricultural.domain.FunctionMenu.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * 功能菜单
 *
 * Created by JIAZEFENG on 2016/08/01.
 */
@Entity
@Table(name = "FUNCTION_MENU")
public class FunctionMenu extends BaseVO{
    /**
     * 菜单ID
     */
    private String mId;
    /**
     * 菜单名称
     */
    private String mName;
    /**
     * 菜单url
     */
    private String mUrl;
    /**
     * 是否导航节点 0：否，1：是
     */
    private int mIfNavigationNode;
    /**
     * 所在层级
     */
    private String mLayer;
    /**
     * 排序
     */
    private String mOrder;
    /**
     * 父级菜单Id
     */
    private String mParentId;
    /**
     * 所属菜单Id
     */
    private String mViewId;
    /**
     * 状态
     */
    private int mState;

    @Id
    @Column(name = "MENU_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    @Basic
    @Column(name = "MENU_NAME", nullable = true, insertable = true, updatable = true, length = 64)
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Basic
    @Column(name = "MENU_URL", nullable = true, insertable = true, updatable = true, length = 128)
    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    @Basic
    @Column(name = "MENU_IFNAVNODE", nullable = true, insertable = true, updatable = true, length = 64)
    public int getmIfNavigationNode() {
        return mIfNavigationNode;
    }

    public void setmIfNavigationNode(int mIfNavigationNode) {
        this.mIfNavigationNode = mIfNavigationNode;
    }

    @Basic
    @Column(name = "MENU_LAYER", nullable = true, insertable = true, updatable = true, length = 64)
    public String getmLayer() {
        return mLayer;
    }

    public void setmLayer(String mLayer) {
        this.mLayer = mLayer;
    }

    @Basic
    @Column(name = "MENU_ORDER", nullable = true, insertable = true, updatable = true, length = 64)
    public String getmOrder() {
        return mOrder;
    }

    public void setmOrder(String mOrder) {
        this.mOrder = mOrder;
    }

    @Basic
    @Column(name = "MENU_PARENTID", nullable = true, insertable = true, updatable = true, length = 64)
    public String getmParentId() {
        return mParentId;
    }

    public void setmParentId(String mParentId) {
        this.mParentId = mParentId;
    }

    @Basic
    @Column(name = "MENU_VIEWID", nullable = true, insertable = true, updatable = true, length = 64)
    public String getmViewId() {
        return mViewId;
    }

    public void setmViewId(String mViewId) {
        this.mViewId = mViewId;
    }

    @Basic
    @Column(name = "MENU_STATE", nullable = true, insertable = true, updatable = true, length = 11)
    public int getmState() {
        return mState;
    }

    public void setmState(int mState) {
        this.mState = mState;
    }

}
