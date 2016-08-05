package com.agricultural.domain.role.repository;

import com.agricultural.domain.role.model.RoleInfo;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/05.
 */
public interface RoleInfoRepository extends BaseRepository<RoleInfo> {
    /**
     * 初始化检索角色列表
     *
     * @return
     */
    public List<RoleInfo> searchRoleInfoList();

    /**
     * 检索角色列表总数
     *
     * @return
     */
    public int searchTotal();

    /**
     * 添加角色
     *
     * @param roleInfo
     * @return
     */
    public boolean addRole(RoleInfo roleInfo);

    public boolean editRole(RoleInfo roleInfo);

    public List<RoleInfo> searchRoleInfo();
}
