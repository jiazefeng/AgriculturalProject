package com.agricultural.service.user.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.user.dto.UserInfoDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.domain.user.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public ApiResult queryUserList(String userId);

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

    //通过token查询用户
    public UserInfo GetUserInfoByTokenValue(String vestatoken);

    /**
     * 修改用户密码
     *
     * @param userInfoDTO
     * @return
     */
    ApiResult updateUserPwd(UserInfoDTO userInfoDTO);

    /**
     * 退出系统
     *
     * @param tokenId
     * @param request
     * @param response
     */
    void logout(String tokenId, HttpServletRequest request, HttpServletResponse response);

    /**
     * 通过userId查询用户权限
     *
     * @param userId
     * @return
     */
    public ApiResult GetInfoByTokenId(String userId);
}
