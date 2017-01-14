package com.agricultural.domain.spcfi.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/29 0029.
 */
@Entity
@Table(name = "SPECFI")
public class Specfi extends BaseVO{
    /**
     * 规范编号
     */


    private String specfiId;
    /**
     * 规范标题
     */
    private String specfiTitle;
    /**
     *规范时间
     */
    private String specfiTime;
    /**
     * 规范链接
     */
    private String specifiLink;

    @Basic
    @Column(name = "SPECFI_LINK", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSpecifiLink() {
        return specifiLink;
    }

    public void setSpecifiLink(String specifiLink) {
        this.specifiLink = specifiLink;
    }

    @Basic
    @Column(name = "SPECFI_TIME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSpecfiTime() {
        return specfiTime;
    }

    public void setSpecfiTime(String specfiTime) {
        this.specfiTime = specfiTime;
    }

    @Basic
    @Column(name = "SPECFI_TITLE", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSpecfiTitle() {
        return specfiTitle;
    }

    public void setSpecfiTitle(String specfiTitle) {
        this.specfiTitle = specfiTitle;
    }
    @Id
    @Column(name = "SPECFI_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getSpecfiId() {
        return specfiId;
    }

    public void setSpecfiId(String specfiId) {
        this.specfiId = specfiId;
    }
}
