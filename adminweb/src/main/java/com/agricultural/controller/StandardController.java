package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.breed.dto.BreedDTO;
import com.agricultural.domain.standard.dto.StandardDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.breed.inf.BreedService;
import com.agricultural.service.standard.inf.StandardService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 标准管理
 * Created by jiazefeng on 2017/01/24.
 */
@RestController
@RequestMapping(value = "/standard")
public class StandardController {
    @Autowired
    UserService userService;
    @Autowired
    StandardService standardService;
    /**
     * 初始化检索全部信息
     *
     * @return
     */
    @RequestMapping(value = "/searchStandardList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchStandardList() {
        return standardService.searchStandardList();
    }

    /**
     * 按条件检索全部列表信息
     *
     * @return
     */
    @RequestMapping(value = "/searchStandardListByItem", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult searchStandardListByItem(@RequestBody StandardDTO standardDTO) {
        return standardService.searchStandardListByItem(standardDTO);
    }


    /**
     * 根据id查询信息
     */
    @RequestMapping(value = "/searchStandardById/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchStandardById(@PathVariable("id") String id) {
        return standardService.searchStandardById(id);
    }

    /**
     * 添加信息
     *
     * @return
     */
    @RequestMapping(value = "/addStandard", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addStandard(@CookieValue(value = "vestaToken", required = false) String tokenId,@RequestBody StandardDTO standardDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return standardService.addStandard(standardDTO, userInfos);
    }

    /**
     * 编辑信息
     *
     * @return
     */
    @RequestMapping(value = "/editStandard", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editStandard(@CookieValue(value = "vestaToken", required = false) String tokenId,@RequestBody StandardDTO standardDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return standardService.editStandard(standardDTO, userInfos);
    }

    /**
     * 删除信息
     */
    @RequestMapping(value = "/deleteStandard/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult deleteStandard(@PathVariable("id") String id) {
        return standardService.deleteStandard(id);
    }


}
