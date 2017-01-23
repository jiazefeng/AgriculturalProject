package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.milk.dto.MilkDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.milk.inf.MilkService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 牛奶管理
 * Created by Talent on 2017/1/23.
 */
@RestController
@RequestMapping(value = "milk")
public class MilkController {
    @Autowired
    UserService userService;
    @Autowired
    MilkService milkService;
    /**
     * 查询列表
     */
    @RequestMapping(value = "/getMilkInfoList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult getMilkInfoList(@CookieValue(value = "vestaToken", required = false) String tokenId) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return milkService.getMilkInfoList();
    }
    /**
     * 按条件查询列表
     */
    @RequestMapping(value = "/getMilkInfoListByItem", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult getMilkInfoListByItem(@CookieValue(value = "vestaToken", required = false) String tokenId,@RequestBody MilkDTO milkDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return milkService.getMilkInfoList(milkDTO);
    }

    /**
     * 根据id查询功能信息
     */
    @RequestMapping(value = "/getMilkInfoById/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult getMilkInfoById(@PathVariable("id") String id) {
        return milkService.getMilkInfoById(id);
    }

    /**
     * 添加信息
     *
     * @return
     */
    @RequestMapping(value = "/addMilkInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addMilkInfo(@CookieValue(value = "vestaToken", required = false) String tokenId, @RequestBody MilkDTO milkDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return milkService.addMilkInfo(milkDTO, userInfos);
    }

    /**
     * 编辑信息
     *
     * @return
     */
    @RequestMapping(value = "/editMilkInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editMilkInfo(@CookieValue(value = "vestaToken", required = false) String tokenId, @RequestBody MilkDTO milkDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return milkService.editMilkInfo(milkDTO, userInfos);
    }

    /**
     * 删除信息
     */
    @RequestMapping(value = "/deleteMilkInfo/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult deleteMilkInfo(@PathVariable("id") String id) {
        return milkService.deleteMilkInfo(id);
    }
}
