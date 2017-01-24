package com.agricultural.domain.standard.dto;

import com.agricultural.page.PageInfoTools;

import java.util.Date;

/**
 * Created by Talent on 2017/1/24.
 */
public class StandardDTO extends PageInfoTools {
    private String standardId;
    private String standardNum;
    private String standardTitle;
    private String standardUrl;
    private Date standardDate;

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getStandardNum() {
        return standardNum;
    }

    public void setStandardNum(String standardNum) {
        this.standardNum = standardNum;
    }

    public String getStandardTitle() {
        return standardTitle;
    }

    public void setStandardTitle(String standardTitle) {
        this.standardTitle = standardTitle;
    }

    public String getStandardUrl() {
        return standardUrl;
    }

    public void setStandardUrl(String standardUrl) {
        this.standardUrl = standardUrl;
    }

    public Date getStandardDate() {
        return standardDate;
    }

    public void setStandardDate(Date standardDate) {
        this.standardDate = standardDate;
    }
}
