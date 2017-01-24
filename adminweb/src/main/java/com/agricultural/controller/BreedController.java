package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.breed.dto.BreedDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.breed.inf.BreedService;
import com.agricultural.service.function.inf.FunctionService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 繁殖管理
 * Created by jiazefeng on 2017/01/24.
 */
@RestController
@RequestMapping(value = "/breed")
public class BreedController {
    @Autowired
    BreedService breedService;
    @Autowired
    UserService userService;
    /**
     * 初始化检索全部信息
     *
     * @return
     */
    @RequestMapping(value = "/searBreedList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searBreedList() {
        return breedService.searBreedList();
    }

    /**
     * 按条件检索全部列表信息
     *
     * @return
     */
    @RequestMapping(value = "/searBreedListByItem", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult searBreedListByItem(@RequestBody BreedDTO breedDTO) {
        return breedService.searBreedListByItem(breedDTO);
    }


    /**
     * 根据id查询信息
     */
    @RequestMapping(value = "/searchBreedById/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchBreedById(@PathVariable("id") String id) {
        return breedService.searchBreedById(id);
    }

    /**
     * 添加信息
     *
     * @return
     */
    @RequestMapping(value = "/addBreed", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addBreed(@CookieValue(value = "vestaToken", required = false) String tokenId,@RequestBody BreedDTO breedDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return breedService.addBreed(breedDTO,userInfos);
    }

    /**
     * 编辑信息
     *
     * @return
     */
    @RequestMapping(value = "/editBreed", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editBreed(@CookieValue(value = "vestaToken", required = false) String tokenId,@RequestBody BreedDTO breedDTO) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return breedService.editBreed(breedDTO,userInfos);
    }

    /**
     * 删除信息
     */
    @RequestMapping(value = "/deleteBreed/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult deleteBreed(@PathVariable("id") String id) {
        return breedService.deleteBreed(id);
    }


}
