package com.agricultural.domain.farm.dto;

import com.agricultural.page.PageInfoTools;

/**
 * Created by jiazefeng on 2016/08/12.
 */
public class RanchingTypeDto extends PageInfoTools {
    private String rtId;
    private String rtName;//类型名称
    private String rtNumber;//类型编号
    private String rtImge;//图片
    private String rtProfile;//简介
    private String rtParentId;
    private int rtLevel;
    private String rtParentName;

    public String getRtId() {
        return rtId;
    }

    public void setRtId(String rtId) {
        this.rtId = rtId;
    }

    public String getRtName() {
        return rtName;
    }

    public void setRtName(String rtName) {
        this.rtName = rtName;
    }

    public String getRtNumber() {
        return rtNumber;
    }

    public void setRtNumber(String rtNumber) {
        this.rtNumber = rtNumber;
    }

    public String getRtImge() {
        return rtImge;
    }

    public void setRtImge(String rtImge) {
        this.rtImge = rtImge;
    }

    public String getRtProfile() {
        return rtProfile;
    }

    public void setRtProfile(String rtProfile) {
        this.rtProfile = rtProfile;
    }

    public String getRtParentId() {
        return rtParentId;
    }

    public void setRtParentId(String rtParentId) {
        this.rtParentId = rtParentId;
    }

    public int getRtLevel() {
        return rtLevel;
    }

    public void setRtLevel(int rtLevel) {
        this.rtLevel = rtLevel;
    }

    public String getRtParentName() {
        return rtParentName;
    }

    public void setRtParentName(String rtParentName) {
        this.rtParentName = rtParentName;
    }
}
