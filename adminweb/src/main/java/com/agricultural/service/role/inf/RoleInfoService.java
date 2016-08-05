package com.agricultural.service.role.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.role.dto.RoleInfoDto;

/**
 * Created by jiazefeng on 2016/08/05.
 */
public interface RoleInfoService {
    /**
     * 检索全部角色列表
     *
     * @return
     */
    public ApiResult searchRoleInfoList();

    /**
     * 添加角色
     *
     * @param roleInfoDto
     * @return
     */
    public ApiResult addRole(RoleInfoDto roleInfoDto);

    /**
     * 根据ID 检索角色信息
     *
     * @param id
     * @return
     */
    public ApiResult searchRoleInfoById(String id);

    /**
     * 编辑角色信息
     *
     * @param roleInfoDto
     * @return
     */
    public ApiResult editRoleInfo(RoleInfoDto roleInfoDto);

    /**
     * 检索全部角色信息
     *
     * @return
     */
    public ApiResult searchRoleInfo();
}
