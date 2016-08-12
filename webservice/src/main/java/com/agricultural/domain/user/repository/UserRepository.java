package com.agricultural.domain.user.repository;

import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/06.
 */
public interface UserRepository extends BaseRepository<UserInfo> {
    /**
     * 用户登录
     *
     * @param userInfo
     * @return
     */
    public UserInfo login(UserInfo userInfo);

    /**
     * 添加用户
     *
     * @param userInfo
     * @return
     */
    public boolean addUser(UserInfo userInfo);

    /**
     * 修改用户信息
     *
     * @param userInfo
     * @return
     */
    public boolean editUser(UserInfo userInfo);

    /**
     * 查询用户列表
     *
     * @return
     */
    public List<UserInfo> searchUserList(String userId);

    /**
     * 查询总条数
     */
    public int searchUserCount();

    /**
     * 根据用户id查询
     */
    public UserInfo searchUserInfoByUserId(String userId);
}
