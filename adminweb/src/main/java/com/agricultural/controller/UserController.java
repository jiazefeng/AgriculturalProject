package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.user.dto.UserInfoDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.user.inf.UserLoginInfoService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiazefeng on 2016/08/02.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLoginInfoService userLoginInfoService;

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
    public ApiResult searchUserInfoList(@CookieValue(value = "vestaToken", required = false) String tokenId) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return userService.queryUserList(userInfos.getuId());
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

    /**
     * 修改用户密码
     *
     * @return
     */
    @RequestMapping(value = "/updateUserPwd", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult updateUserPwd(@RequestBody UserInfoDTO userInfoDTO, @CookieValue(value = "vestaToken", required = false) String tokenId) {

        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        String userId = userLoginInfoService.getUserIdBytokenId(tokenId);
        if (userInfoDTO != null) {
            userInfoDTO.setuId(userId);
        }
        return userService.updateUserPwd(userInfoDTO);
    }
    /**
     * 退出系统
     *
     * @return
     */
    @RequestMapping(value = "/logout", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult logout(@CookieValue(value = "vestaToken", required = false) String tokenId, HttpServletRequest request, HttpServletResponse response) {
        if (tokenId != null && !tokenId.equals("")) {
            userService.logout(tokenId, request, response);
        }
        return new SuccessApiResult("退出成功！");
    }

    /**
     * 通过tokenId查询角色权限
     */
    @RequestMapping(value = "/getRoleAndUserByTokenId", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult getRoleAndUserByTokenId(@CookieValue(value = "vestaToken", required = false) String tokenId) {
        UserInfo userInfo = userService.GetUserInfoByTokenValue(tokenId);
        if (userInfo == null) {
            return new SuccessApiResult("当前未登陆");
        }
        return userService.GetInfoByTokenId(userInfo.getuId());
    }

}
