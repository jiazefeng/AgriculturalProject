package com.agricultural.domain.milk.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * Created by Talent on 2017/1/23.
 */
@Entity
@Table(name = "MILK")
public class MilkEntity extends BaseVO {
    private String milkId;
    private String individualRegistration;//个体登记
    private String groupRegistration;//群体登记
    @Id
    @Column(name = "MILK_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getMilkId() {
        return milkId;
    }

    public void setMilkId(String milkId) {
        this.milkId = milkId;
    }
    @Basic
    @Column(name = "INDIVIDUAL_REG", nullable = true, length = 200)
    public String getIndividualRegistration() {
        return individualRegistration;
    }

    public void setIndividualRegistration(String individualRegistration) {
        this.individualRegistration = individualRegistration;
    }
    @Basic
    @Column(name = "GROUP_REG", nullable = true, length = 200)
    public String getGroupRegistration() {
        return groupRegistration;
    }

    public void setGroupRegistration(String groupRegistration) {
        this.groupRegistration = groupRegistration;
    }
}
