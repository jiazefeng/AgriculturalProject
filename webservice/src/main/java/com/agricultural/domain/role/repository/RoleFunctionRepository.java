package com.agricultural.domain.role.repository;

import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.role.model.RoleFunction;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/05.
 */
public interface RoleFunctionRepository extends BaseRepository<RoleFunction> {
    /**
     * 添加
     *
     * @param roleFunction
     * @return
     */
    public boolean addRoleFunction(RoleFunction roleFunction);

    /**
     * 根据角色Id 检索对应的权限
     *
     * @param roleId
     * @return
     */
    public List<RoleFunction> roleFunctionList(String roleId);

    /**
     * 根据功能Id 检索对应的权限
     *
     * @param fId
     * @return
     */
    public List<RoleFunction> seachRoleFunctionListByFid(String fId);

    /**
     * 删除权限列表
     *
     * @param roleFunctionList
     * @return
     */
    public boolean deleteRoleFunction(List<RoleFunction> roleFunctionList);


}
