package com.agricultural.service.user.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.user.dto.UserInfoDTO;
import com.agricultural.domain.user.repository.UserRepository;

/**
 * Created by maxrocky on 2016/08/06.
 */
public interface UserService {
    /**
     * 添加
     */
    public ApiResult addUser(UserInfoDTO userInfoDTO);

    /**
     * 查询列表
     */
    public ApiResult queryUserList();

    /**
     * 根据id检索用户信息
     */
    public ApiResult searchUserInfoById(String userId);

    /**
     * 编辑用户信息
     */
    public ApiResult editUserInfo(UserInfoDTO userInfoDTO);

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    ApiResult deleteUserInfo(String id);
}
