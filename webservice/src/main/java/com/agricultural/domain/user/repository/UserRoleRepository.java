package com.agricultural.domain.user.repository;

import com.agricultural.domain.user.model.UserRole;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by maxrocky on 2016/08/06.
 */
public interface UserRoleRepository extends BaseRepository<UserRole> {
    /**
     * 添加用户角色
     * @param userRole
     * @return
     */
    public boolean addUserRole(UserRole userRole);

    /**
     * 删除用户角色
     * @param userRole
     * @return
     */
    public boolean deleteUserRole(UserRole userRole);
    /**
     * 根据用户id查询角色信息
     */
    public  List<UserRole> searchUserRoleListByUserId(String userId);
    /**
     * 只查询对象
     */
    public  UserRole searchUserRoleByUserId(String userId);
    /**
     * 修改
     */
    public boolean editUserRole(UserRole userRole);
}
