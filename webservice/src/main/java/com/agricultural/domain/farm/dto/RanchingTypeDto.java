package com.agricultural.domain.farm.dto;

import com.agricultural.page.PageInfoTools;

/**
 * Created by jiazefeng on 2016/08/12.
 */
public class RanchingTypeDto extends PageInfoTools {
    private String rtId;
    private String rtName;//类型名称
    private String rtNumber;//类型编号
    private String rtImge;//图片

    public String getRtId() {
        return rtId;
    }

    public void setRtId(String rtId) {
        this.rtId = rtId;
    }

    public String getRtName() {
        return rtName;
    }

    public void setRtName(String rtName) {
        this.rtName = rtName;
    }

    public String getRtNumber() {
        return rtNumber;
    }

    public void setRtNumber(String rtNumber) {
        this.rtNumber = rtNumber;
    }

    public String getRtImge() {
        return rtImge;
    }

    public void setRtImge(String rtImge) {
        this.rtImge = rtImge;
    }
}
