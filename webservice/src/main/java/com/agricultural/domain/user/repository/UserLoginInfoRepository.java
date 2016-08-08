package com.agricultural.domain.user.repository;

import com.agricultural.domain.user.model.UserLoginInfo;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/08.
 */
public interface UserLoginInfoRepository extends BaseRepository<UserLoginInfo> {
    /**
     * 添加用户登录信息
     *
     * @param userLoginInfo
     * @return
     */
    public boolean addUserLoginInfo(UserLoginInfo userLoginInfo);

    /**
     * 通过用户tokenId 查询用户ID
     *
     * @param tokenId
     * @return
     */
    String getUserIdBytokenId(String tokenId);
    /**
     * 根据tokenId查询登录信息
     *
     * @param tokenId
     * @return
     */
    List<UserLoginInfo> logout(String tokenId);
}
