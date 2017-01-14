package com.agricultural.domain.spcfi.dto;

/**
 * Created by Administrator on 2016/12/29 0029.
 */
public class SpecfiDTO {
    /**
     * 规范编号
     */
    private String specfiId;
    /**
     * 规范标题
     */
    private String specfiTitle;
    /**
     * 规范时间
     */
    private String specfiTime;
    /**
     * 规范链接
     */
    private String specifiLink;

    public String getSpecifiLink() {
        return specifiLink;
    }

    public void setSpecifiLink(String specifiLink) {
        this.specifiLink = specifiLink;
    }

    public String getSpecfiTime() {
        return specfiTime;
    }

    public void setSpecfiTime(String specfiTime) {
        this.specfiTime = specfiTime;
    }

    public String getSpecfiTitle() {
        return specfiTitle;
    }

    public void setSpecfiTitle(String specfiTitle) {
        this.specfiTitle = specfiTitle;
    }

    public String getSpecfiId() {
        return specfiId;
    }

    public void setSpecfiId(String specfiId) {
        this.specfiId = specfiId;
    }
}
