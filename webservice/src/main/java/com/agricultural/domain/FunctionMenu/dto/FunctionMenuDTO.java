package com.agricultural.domain.FunctionMenu.dto;

/**
 * Created by maxrocky on 2016/08/03.
 */
public class FunctionMenuDTO {
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
    private String mParentName;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public int getmIfNavigationNode() {
        return mIfNavigationNode;
    }

    public void setmIfNavigationNode(int mIfNavigationNode) {
        this.mIfNavigationNode = mIfNavigationNode;
    }

    public String getmLayer() {
        return mLayer;
    }

    public void setmLayer(String mLayer) {
        this.mLayer = mLayer;
    }

    public String getmOrder() {
        return mOrder;
    }

    public void setmOrder(String mOrder) {
        this.mOrder = mOrder;
    }

    public String getmParentId() {
        return mParentId;
    }

    public void setmParentId(String mParentId) {
        this.mParentId = mParentId;
    }

    public String getmParentName() {
        return mParentName;
    }

    public void setmParentName(String mParentName) {
        this.mParentName = mParentName;
    }
}
