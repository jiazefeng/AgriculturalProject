package com.agricultural.domain.farm.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jiazefeng on 2016/08/12.
 */
@Entity
@Table(name = "RANCHING_INFO")
public class RanchingInfo extends BaseVO {
    /**
     * 畜牧ID
     */
    private String riId;
    /**
     * 畜牧名称
     */
    private String riName;
    /**
     * 畜牧编号
     */
    private String riNumber;
    /**
     * 畜牧体重
     */
    private int riWeight;
    /**
     * 添加时间
     */
    private Date creatDate;
    /**
     * 修改时间
     */
    private Date editDate;
    /**
     * 是否怀孕
     */
    private int ifPregnant;
    /**
     * 怀孕时间
     */
    private Date pregnantDate;
    /**
     * 所属种类id
     */
    private String ranchingTypeId;
    /**
     * 畜牧图片
     */
    private String riImge;
    /**
     * 畜牧简介
     */
    private String riProfile;
    /**
     * 状态
     */
    private int riState;

    @Id
    @Column(name = "RANCHING_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getRiId() {
        return riId;
    }

    public void setRiId(String riId) {
        this.riId = riId;
    }

    @Basic
    @Column(name = "RANCHING_NAME", nullable = true, insertable = true, updatable = true, length = 64)
    public String getRiName() {
        return riName;
    }

    public void setRiName(String riName) {
        this.riName = riName;
    }

    @Basic
    @Column(name = "RANCHING_NUMBER", nullable = true, insertable = true, updatable = true, length = 64)
    public String getRiNumber() {
        return riNumber;
    }

    public void setRiNumber(String riNumber) {
        this.riNumber = riNumber;
    }

    @Basic
    @Column(name = "RANCHING_WEIGHT", nullable = true, insertable = true, updatable = true, length = 64)
    public int getRiWeight() {
        return riWeight;
    }

    public void setRiWeight(int riWeight) {
        this.riWeight = riWeight;
    }

    @Basic
    @Column(name = "RANCHING_CREATDATE", nullable = true, insertable = true, updatable = true)
    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    @Basic
    @Column(name = "RANCHING_EDITDATE", nullable = true, insertable = true, updatable = true)
    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    @Basic
    @Column(name = "RANCHING_IF_PREGNANT", nullable = true, insertable = true, updatable = true, length = 11)
    public int getIfPregnant() {
        return ifPregnant;
    }

    public void setIfPregnant(int ifPregnant) {
        this.ifPregnant = ifPregnant;
    }

    @Basic
    @Column(name = "RANCHING_PREGNANTDATE", nullable = true, insertable = true, updatable = true)
    public Date getPregnantDate() {
        return pregnantDate;
    }

    public void setPregnantDate(Date pregnantDate) {
        this.pregnantDate = pregnantDate;
    }

    @Basic
    @Column(name = "RANCHING_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 32)
    public String getRanchingTypeId() {
        return ranchingTypeId;
    }

    public void setRanchingTypeId(String ranchingTypeId) {
        this.ranchingTypeId = ranchingTypeId;
    }

    @Basic
    @Column(name = "RANCHING_IMGE", nullable = true, insertable = true, updatable = true, length = 64)
    public String getRiImge() {
        return riImge;
    }

    public void setRiImge(String riImge) {
        this.riImge = riImge;
    }

    @Basic
    @Column(name = "RANCHING_PROFILE", nullable = true, insertable = true, updatable = true, length = 256)
    public String getRiProfile() {
        return riProfile;
    }

    public void setRiProfile(String riProfile) {
        this.riProfile = riProfile;
    }
    @Basic
    @Column(name = "RANCHING_STATE", nullable = true, insertable = true, updatable = true, length = 11)
    public int getRiState() {
        return riState;
    }

    public void setRiState(int riState) {
        this.riState = riState;
    }
}
