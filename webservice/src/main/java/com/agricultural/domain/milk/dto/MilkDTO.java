package com.agricultural.domain.milk.dto;

import com.agricultural.page.PageInfoTools;

/**
 * Created by Talent on 2017/1/23.
 */
public class MilkDTO extends PageInfoTools {
    private String milkId;
    private String individualRegistration;//个体登记
    private String groupRegistration;//群体登记

    public String getMilkId() {
        return milkId;
    }

    public void setMilkId(String milkId) {
        this.milkId = milkId;
    }

    public String getIndividualRegistration() {
        return individualRegistration;
    }

    public void setIndividualRegistration(String individualRegistration) {
        this.individualRegistration = individualRegistration;
    }

    public String getGroupRegistration() {
        return groupRegistration;
    }

    public void setGroupRegistration(String groupRegistration) {
        this.groupRegistration = groupRegistration;
    }
}
