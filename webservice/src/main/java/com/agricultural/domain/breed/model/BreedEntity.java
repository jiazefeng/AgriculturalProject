package com.agricultural.domain.breed.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * 繁殖
 * Created by Talent on 2017/1/24.
 */
@Entity
@Table(name = "BREED")
public class BreedEntity extends BaseVO {
    private String breedId;//ID
    private String breedNum;//数量
    private String breedHomeNum;//牛舍号
    private String breedType;//类型

    @Id
    @Column(name = "BREED_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getBreedId() {
        return breedId;
    }

    public void setBreedId(String breedId) {
        this.breedId = breedId;
    }

    @Basic
    @Column(name = "BREED_NUM", nullable = true, insertable = true, updatable = true, length = 64)
    public String getBreedNum() {
        return breedNum;
    }

    public void setBreedNum(String breedNum) {
        this.breedNum = breedNum;
    }

    @Basic
    @Column(name = "BREED_HOME_NUM", nullable = true, insertable = true, updatable = true, length = 64)
    public String getBreedHomeNum() {
        return breedHomeNum;
    }

    public void setBreedHomeNum(String breedHomeNum) {
        this.breedHomeNum = breedHomeNum;
    }

    @Basic
    @Column(name = "BREED_TYPE", nullable = true, insertable = true, updatable = true, length = 64)
    public String getBreedType() {
        return breedType;
    }

    public void setBreedType(String breedType) {
        this.breedType = breedType;
    }
}
