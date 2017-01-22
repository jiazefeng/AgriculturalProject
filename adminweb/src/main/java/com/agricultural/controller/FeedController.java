package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.feed.inf.FeedService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *饲料管理
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
}
