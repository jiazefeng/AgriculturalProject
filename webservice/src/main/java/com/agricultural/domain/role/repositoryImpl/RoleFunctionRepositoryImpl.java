package com.agricultural.domain.role.repositoryImpl;

import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.role.model.RoleFunction;
import com.agricultural.domain.role.model.RoleInfo;
import com.agricultural.domain.role.repository.RoleFunctionRepository;
import com.agricultural.domain.user.model.UserRole;
import com.agricultural.hibernate.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiazefeng on 2016/08/05.
 */
@Repository
public class RoleFunctionRepositoryImpl extends BaseRepositoryImpl<RoleFunction> implements RoleFunctionRepository {
    @Override
    public boolean addRoleFunction(RoleFunction roleFunction) {
        this.save(roleFunction);
        return true;
    }

    @Override
    public List<RoleFunction> roleFunctionList(String roleId) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from RoleFunction as rf where rf.roleId = ? ";
        params.add(roleId);
        List<RoleFunction> roleFunctionList = this.findByQueryList(hql, params);
        return roleFunctionList;
    }

    @Override
    public List<RoleFunction> seachRoleFunctionListByFid(String fId) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from RoleFunction as rf where rf.funcId = ? ";
        params.add(fId);
        List<RoleFunction> roleFunctionList = this.findByQueryList(hql, params);
        return roleFunctionList;
    }

    @Override
    public boolean deleteRoleFunction(List<RoleFunction> roleFunctionList) {
        for (RoleFunction roleFunction : roleFunctionList) {
            this.deletePhysical(roleFunction);
        }
        return true;
    }

}
