package com.agricultural.domain.FunctionMenu.dto;

import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.page.PageInfoTools;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/03.
 */
public class FunctionMenuDTO extends PageInfoTools {
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
    private int mLayer;
    /**
     * 排序
     */
    private int mOrder;
    /**
     * 父级菜单Id
     */
    private String mParentId;
    /**
     * 父级菜单名称
     */
    private String mParentName;
    /**
     * 所有子菜单
     */
    private List<FunctionMenu> allSubmenuList;

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

    public int getmLayer() {
        return mLayer;
    }

    public void setmLayer(int mLayer) {
        this.mLayer = mLayer;
    }

    public int getmOrder() {
        return mOrder;
    }

    public void setmOrder(int mOrder) {
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

    public List<FunctionMenu> getAllSubmenuList() {
        return allSubmenuList;
    }

    public void setAllSubmenuList(List<FunctionMenu> allSubmenuList) {
        this.allSubmenuList = allSubmenuList;
    }
}
