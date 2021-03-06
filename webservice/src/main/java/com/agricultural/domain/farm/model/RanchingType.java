package com.agricultural.domain.farm.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * 畜牧类型
 * Created by jiazefeng on 2016/08/12.
 */
@Entity
@Table(name = "RANCHING_TYPE")
public class RanchingType extends BaseVO {
    private String rtId;
    private String rtName;//类型名称
    private String rtNumber;//类型编号
    private String rtImge;//图片
    private String rtProfile;//简介
    private String rtParentId;//
    private int rtLevel;//级别
    private int rtState;//

    @Id
    @Column(name = "RANCHING_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getRtId() {
        return rtId;
    }

    public void setRtId(String rtId) {
        this.rtId = rtId;
    }

    @Basic
    @Column(name = "RANCHING_TYPE_NAME", nullable = true, insertable = true, updatable = true, length = 64)
    public String getRtName() {
        return rtName;
    }

    public void setRtName(String rtName) {
        this.rtName = rtName;
    }

    @Basic
    @Column(name = "RANCHING_TYPE_NUMBER", nullable = true, insertable = true, updatable = true, length = 64)
    public String getRtNumber() {
        return rtNumber;
    }

    public void setRtNumber(String rtNumber) {
        this.rtNumber = rtNumber;
    }

    @Basic
    @Column(name = "RANCHING_TYPE_STATE", nullable = true, insertable = true, updatable = true, length = 2)
    public int getRtState() {
        return rtState;
    }

    public void setRtState(int rtState) {
        this.rtState = rtState;
    }
    @Basic
    @Column(name = "RANCHING_TYPE_IMGE", nullable = true, insertable = true, updatable = true, length = 64)
    public String getRtImge() {
        return rtImge;
    }

    public void setRtImge(String rtImge) {
        this.rtImge = rtImge;
    }
    @Basic
    @Column(name = "RANCHING_TYPE_PROFILE", nullable = true, insertable = true, updatable = true, length = 256)
    public String getRtProfile() {
        return rtProfile;
    }

    public void setRtProfile(String rtProfile) {
        this.rtProfile = rtProfile;
    }
    @Basic
    @Column(name = "RANCHING_TYPE_PARENTID", nullable = true, insertable = true, updatable = true, length = 32)
    public String getRtParentId() {
        return rtParentId;
    }

    public void setRtParentId(String rtParentId) {
        this.rtParentId = rtParentId;
    }
    @Basic
    @Column(name = "RANCHING_TYPE_LEVEL", nullable = true, insertable = true, updatable = true, length = 11)
    public int getRtLevel() {
        return rtLevel;
    }

    public void setRtLevel(int rtLevel) {
        this.rtLevel = rtLevel;
    }
}
