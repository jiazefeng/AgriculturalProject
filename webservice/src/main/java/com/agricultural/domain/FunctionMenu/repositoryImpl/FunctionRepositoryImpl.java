package com.agricultural.domain.FunctionMenu.repositoryImpl;

import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.FunctionMenu.repository.FunctionRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiazefeng on 2016/08/02.
 */
@Repository
public class FunctionRepositoryImpl extends BaseRepositoryImpl<FunctionMenu> implements FunctionRepository {
    @Override
    public boolean addFunction(FunctionMenu functionMenu) {
        this.save(functionMenu);
        return true;
    }

    @Override
    public List<FunctionMenu> searchFunction() {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM FunctionMenu as m where m.mState=?";
        params.add(1);
        hql += " ORDER BY m.mLayer,m.mOrder ASC";
        List<FunctionMenu> functionMenuList = this.findByQueryList(hql, params);
        return functionMenuList;
    }

    @Override
    public List<FunctionMenu> searchFunctionList() {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM FunctionMenu as m where m.mState=?";
        params.add(1);
        hql += " ORDER BY m.mLayer,m.mOrder ASC";
        List<FunctionMenu> functionMenuList = this.findByQueryList(hql, new PageInfoTools(), params);
        return functionMenuList;
    }

    @Override
    public FunctionMenu searchFunctionMenuByMid(String mId) {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM FunctionMenu as m where m.mId=? ";
        params.add(mId);

        return (FunctionMenu) this.findObjectByQueryResult(hql, params);
    }

    @Override
    public int searchTotal() {
        List<Criterion> sql = new ArrayList<Criterion>();
        sql.add(Restrictions.eq("mState", 1));
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public boolean editFunction(FunctionMenu functionMenu) {
        this.update(functionMenu);
        return true;
    }

    @Override
    public List<FunctionMenu> searchFunctionListByItem(int index) {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM FunctionMenu as m where m.mState=?";
        params.add(1);
        hql += " ORDER BY m.mLayer,m.mOrder ASC";
        List<FunctionMenu> functionMenuList = this.findByQueryList(hql, new PageInfoTools(index, 10), params);
        return functionMenuList;
    }

    @Override
    public int searchTotalByItem(int index) {
        return 0;
    }

    @Override
    public List<FunctionMenu> searchMainMenu() {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM FunctionMenu as m where m.mState=? and m.mIfNavigationNode=?";
        params.add(1);
        params.add(1);
        List<FunctionMenu> functionMenuList = this.findByQueryList(hql,params);
        return functionMenuList;
    }

    @Override
    public List<FunctionMenu> searchTwoLevelMenu(String id) {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM FunctionMenu as m where m.mState=? and m.mIfNavigationNode=? and m.mParentId=?";
        params.add(1);
        params.add(0);
        params.add(id);
        List<FunctionMenu> functionMenuList = this.findByQueryList(hql,params);
        return functionMenuList;
    }
}
