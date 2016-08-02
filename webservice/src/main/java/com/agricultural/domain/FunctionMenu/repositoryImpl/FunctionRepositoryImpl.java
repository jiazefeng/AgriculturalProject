package com.agricultural.domain.FunctionMenu.repositoryImpl;

import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.FunctionMenu.repository.FunctionRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiazefeng on 2016/08/02.
 */
public class FunctionRepositoryImpl extends BaseRepositoryImpl<FunctionMenu> implements FunctionRepository {
    @Override
    public boolean addFunction(FunctionMenu functionMenu) {
        this.save(functionMenu);
        return true;
    }

    @Override
    public List<FunctionMenu> searchFunctionList() {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM FunctionMenu as m where m.mState=?";
        params.add(1);
        hql += " ORDER BY m.mOrder ASC";
        List<FunctionMenu> functionMenuList = this.findByQueryList(hql,params);
        return functionMenuList;
    }
}
