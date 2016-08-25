package com.agricultural.domain.farm.dto;

import com.agricultural.page.PageInfoTools;

import java.util.Date;

/**
 * Created by jiazefeng on 2016/08/24.
 */
public class RanchingInfoDTO extends PageInfoTools{

    private String id;
    /**
     * 畜牧名称
     */
    private String name;
    /**
     * 畜牧编号
     */
    private String number;
    /**
     * 畜牧体重
     */
    private int riWeight;
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
     * 畜牧种类名称
     */
    private String ranchingTypeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getRiWeight() {
        return riWeight;
    }

    public void setRiWeight(int riWeight) {
        this.riWeight = riWeight;
    }

    public int getIfPregnant() {
        return ifPregnant;
    }

    public void setIfPregnant(int ifPregnant) {
        this.ifPregnant = ifPregnant;
    }

    public Date getPregnantDate() {
        return pregnantDate;
    }

    public void setPregnantDate(Date pregnantDate) {
        this.pregnantDate = pregnantDate;
    }

    public String getRanchingTypeId() {
        return ranchingTypeId;
    }

    public void setRanchingTypeId(String ranchingTypeId) {
        this.ranchingTypeId = ranchingTypeId;
    }

    public String getRiImge() {
        return riImge;
    }

    public void setRiImge(String riImge) {
        this.riImge = riImge;
    }

    public String getRiProfile() {
        return riProfile;
    }

    public void setRiProfile(String riProfile) {
        this.riProfile = riProfile;
    }

    public String getRanchingTypeName() {
        return ranchingTypeName;
    }

    public void setRanchingTypeName(String ranchingTypeName) {
        this.ranchingTypeName = ranchingTypeName;
    }
}
