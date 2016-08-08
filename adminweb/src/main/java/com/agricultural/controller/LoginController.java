package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.user.dto.LoginDto;
import com.agricultural.service.login.inf.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiazefeng on 2016/08/08.
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    /**
     * 用户登录
     *
     * @param loginDto
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult login(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) {
        return loginService.login(loginDto,request,response);
    }
}
