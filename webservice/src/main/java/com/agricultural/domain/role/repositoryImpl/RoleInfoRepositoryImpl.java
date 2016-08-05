package com.agricultural.domain.role.repositoryImpl;

import com.agricultural.domain.role.model.RoleInfo;
import com.agricultural.domain.role.repository.RoleInfoRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiazefeng on 2016/08/05.
 */
@Repository
public class RoleInfoRepositoryImpl extends BaseRepositoryImpl<RoleInfo> implements RoleInfoRepository {
    @Override
    public List<RoleInfo> searchRoleInfoList() {
        List<Object> params = new ArrayList<Object>();
        String hql = "from RoleInfo as ri where 1=1 ";
        List<RoleInfo> roleInfoList = this.findByQueryList(hql, new PageInfoTools(), params);
        return roleInfoList;
    }

    @Override
    public int searchTotal() {
        List<Criterion> sql = new ArrayList<Criterion>();
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public boolean addRole(RoleInfo roleInfo) {
        this.save(roleInfo);
        return true;
    }

    @Override
    public boolean editRole(RoleInfo roleInfo) {
        this.update(roleInfo);
        return true;
    }

    @Override
    public List<RoleInfo> searchRoleInfo() {
        List<Object> params = new ArrayList<Object>();
        String hql = "from RoleInfo as ri where ri.rState=? ";
        params.add(1);
        List<RoleInfo> roleInfoList = this.findByQueryList(hql, params);
        return roleInfoList;
    }
}
