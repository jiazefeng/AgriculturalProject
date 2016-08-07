package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.user.dto.UserInfoDTO;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiazefeng on 2016/08/02.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户
     */
    @RequestMapping(value = "/addUser", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addUser(@RequestBody UserInfoDTO userInfoDTO) {
        return userService.addUser(userInfoDTO);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/searchUserInfoList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchUserInfoList() {
        return userService.queryUserList();
    }

    /**
     * 编辑用户
     */
    @RequestMapping(value = "/editUserInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        return userService.editUserInfo(userInfoDTO);
    }

    /**
     * 根据id查询用户信息
     */
    @RequestMapping(value = "/searchUserInfoById/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchUserInfoById(@PathVariable("id") String id) {
        return userService.searchUserInfoById(id);
    }

    /**
     * 删除用户信息
     */
    @RequestMapping(value = "/deleteUserInfo/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.DELETE)
    public ApiResult deleteUserInfo(@PathVariable("id") String id) {
        return userService.deleteUserInfo(id);
    }


}
