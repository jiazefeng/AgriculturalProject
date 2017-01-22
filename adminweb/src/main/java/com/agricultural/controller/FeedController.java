package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.feed.dto.FeedDto;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.feed.inf.FeedService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 饲料管理
 * Created by Talent on 2016/12/29.
 */
@RestController
@RequestMapping(value = "/feed")
public class FeedController {
    @Autowired
    FeedService feedService;
    @Autowired
    UserService userService;

    /**
     * 查询列表
     */
    @RequestMapping(value = "/getFeedInfoList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult getFeedInfoList(@CookieValue(value = "vestaToken", required = false) String tokenId) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return feedService.getFeedInfoList();
    }
    /**
     * 根据id查询功能信息
     */
    @RequestMapping(value = "/searchFeedById/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchFeedById(@PathVariable("id") String id) {
        return feedService.searchFeedById(id);
    }
    /**
     * 添加饲料管理
     *
     * @return
     */
    @RequestMapping(value = "/addFeed", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addFeed(@CookieValue(value = "vestaToken", required = false) String tokenId,@RequestBody FeedDto feedDto) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return feedService.addFeed(feedDto,userInfos);
    }
    /**
     * 编辑功能
     *
     * @return
     */
    @RequestMapping(value = "/editFeed", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editFeed(@CookieValue(value = "vestaToken", required = false) String tokenId,@RequestBody FeedDto feedDto) {
        UserInfo userInfos = userService.GetUserInfoByTokenValue(tokenId);
        ModelMap result = new ModelMap();
        if (userInfos == null) {
            result.addAttribute("error", "当前未登录！");
            return new SuccessApiResult(result);
        }
        return feedService.editFeed(feedDto,userInfos);
    }
    /**
     * 删除功能信息
     */
    @RequestMapping(value = "/deleteFeed/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult deleteFeed(@PathVariable("id") String id) {
        return feedService.deleteFunction(id);
    }
}
