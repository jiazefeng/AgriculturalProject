package com.agricultural.domain.ill.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * Created by Talent on 2017/1/23.
 */
@Entity
@Table(name = "ILL")
public class ComminIll extends BaseVO {
    private String illId;
    private String illName;//疾病名称
    private String illYW;//药物
    private String illZZ;//常见症状

    @Id
    @Column(name = "ILL_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getIllId() {
        return illId;
    }

    public void setIllId(String illId) {
        this.illId = illId;
    }
    @Basic
    @Column(name = "ILL_NAME", nullable = true, length = 200)
    public String getIllName() {
        return illName;
    }

    public void setIllName(String illName) {
        this.illName = illName;
    }
    @Basic
    @Column(name = "ILL_YW", nullable = true, length = 200)
    public String getIllYW() {
        return illYW;
    }

    public void setIllYW(String illYW) {
        this.illYW = illYW;
    }
    @Basic
    @Column(name = "ILL_ZZ", nullable = true, length = 200)
    public String getIllZZ() {
        return illZZ;
    }

    public void setIllZZ(String illZZ) {
        this.illZZ = illZZ;
    }
}
