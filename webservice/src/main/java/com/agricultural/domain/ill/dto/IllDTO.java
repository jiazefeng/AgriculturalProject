package com.agricultural.domain.ill.dto;

import com.agricultural.page.PageInfoTools;

/**
 * Created by Administrator on 2017/1/24 0024.
 */
public class IllDTO extends PageInfoTools{
    private String illId;
    private String illName;//��������
    private String illYW;//ҩ��
    private String illZZ;//����֢״

    public String getIllId() {
        return illId;
    }

    public void setIllId(String illId) {
        this.illId = illId;
    }

    public String getIllName() {
        return illName;
    }

    public void setIllName(String illName) {
        this.illName = illName;
    }

    public String getIllYW() {
        return illYW;
    }

    public void setIllYW(String illYW) {
        this.illYW = illYW;
    }

    public String getIllZZ() {
        return illZZ;
    }

    public void setIllZZ(String illZZ) {
        this.illZZ = illZZ;
    }
}
