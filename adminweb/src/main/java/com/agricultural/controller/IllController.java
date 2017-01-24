package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.ill.dto.IllDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.ill.inf.IllService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/1/23 0023.
 */
@RestController
@RequestMapping(value = "ill")
public class IllController {
    @Autowired
    UserService userService;
    @Autowired
    IllService illService;
    /**
     * 查询列表
     */
    @RequestMapping(value = "/getIllInfoList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult getIllInfoList(@CookieValue(value = "vestaToken", required = false) String tokenId) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return illService.getIllInfoList();
    }
    /**
     * 按条件查询列表
     */
    @RequestMapping(value = "/getIllInfoListByItem", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult getIllInfoListByItem(@CookieValue(value = "vestaToken", required = false) String tokenId,@RequestBody IllDTO illDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return illService.getIllInfoList(illDTO);
    }

    /**
     * 根据id查询功能信息
     */
    @RequestMapping(value = "/getIllInfoById/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult getIllInfoById(@PathVariable("id") String id) {
        return illService.getIllInfoById(id);
    }

    /**
     * 添加信息
     *
     * @return
     */
    @RequestMapping(value = "/addIllInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addIllInfo(@CookieValue(value = "vestaToken", required = false) String tokenId, @RequestBody IllDTO illDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return illService.addIllInfo(illDTO, userInfos);
    }

    /**
     * 编辑信息
     *
     * @return
     */
    @RequestMapping(value = "/editIllInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editMilkInfo(@CookieValue(value = "vestaToken", required = false) String tokenId, @RequestBody IllDTO illDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return illService.editIllInfo(illDTO, userInfos);
    }

    /**
     * 删除信息
     */
    @RequestMapping(value = "/deleteIllInfo/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult deleteIllInfo(@PathVariable("id") String id) {
        return illService.deleteIllInfo(id);
    }
}
