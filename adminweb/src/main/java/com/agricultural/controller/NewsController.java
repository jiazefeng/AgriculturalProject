package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.news.dto.NewDTO;
import com.agricultural.domain.news.model.News;
import com.agricultural.domain.user.dto.LoginDto;
import com.agricultural.domain.user.dto.UserInfoDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.news.inf.NewService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewService newService;
    @Autowired
    private UserService userService;
    /**
     * 添加新闻
     */
    @RequestMapping(value = "/addNew", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addNew(@RequestBody NewDTO newDTO) {
        return newService.addNew(newDTO);
    }
    /**
     * 查询列表
     */
    @RequestMapping(value = "/searchNewsInfoList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchNewsInfoList() {
        return newService.queryNewList();
    }
}
