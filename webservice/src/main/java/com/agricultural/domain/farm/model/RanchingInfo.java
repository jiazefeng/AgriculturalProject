package com.agricultural.domain.farm.model;

import com.agricultural.hibernate.BaseVO;

import java.util.Date;

/**
 * Created by jiazefeng on 2016/08/12.
 */
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
    private String riWeight;
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
}
