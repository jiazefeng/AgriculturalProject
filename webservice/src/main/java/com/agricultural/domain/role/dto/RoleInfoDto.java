package com.agricultural.domain.role.dto;

import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.page.PageInfoTools;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/05.
 */
public class RoleInfoDto extends PageInfoTools{
    private String rId;
    private String rName;
    private int rState;
    private List functionMenus;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public int getrState() {
        return rState;
    }

    public void setrState(int rState) {
        this.rState = rState;
    }

    public List getFunctionMenus() {
        return functionMenus;
    }

    public void setFunctionMenus(List functionMenus) {
        this.functionMenus = functionMenus;
    }
}
