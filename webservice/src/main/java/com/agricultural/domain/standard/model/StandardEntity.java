package com.agricultural.domain.standard.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;
import java.util.Date;

/**
 * 标准
 * Created by Talent on 2017/1/24.
 */
@Entity
@Table(name = "STANDARD")
public class StandardEntity extends BaseVO {
    private String standardId;
    private String standardNum;
    private String standardTitle;
    private String standardUrl;
    private Date standardDate;

    @Id
    @Column(name = "STANDARD_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    @Basic
    @Column(name = "STANDARD_NUM", nullable = true, insertable = true, updatable = true, length = 64)
    public String getStandardNum() {
        return standardNum;
    }

    public void setStandardNum(String standardNum) {
        this.standardNum = standardNum;
    }

    @Basic
    @Column(name = "STANDARD_TITLE", nullable = true, insertable = true, updatable = true, length = 64)
    public String getStandardTitle() {
        return standardTitle;
    }

    public void setStandardTitle(String standardTitle) {
        this.standardTitle = standardTitle;
    }

    @Basic
    @Column(name = "STANDARD_URL", nullable = true, insertable = true, updatable = true, length = 64)
    public String getStandardUrl() {
        return standardUrl;
    }

    public void setStandardUrl(String standardUrl) {
        this.standardUrl = standardUrl;
    }

    @Basic
    @Column(name = "STANDARD_DATE", nullable = true, insertable = true, updatable = true)
    public Date getStandardDate() {
        return standardDate;
    }

    public void setStandardDate(Date standardDate) {
        this.standardDate = standardDate;
    }
}
