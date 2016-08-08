package com.agricultural.service.login.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.user.dto.LoginDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiazefeng on 2016/08/08.
 */
public interface LoginService {
    /**
     * 用户登录
     *
     * @param loginDto
     * @param request
     * @param response
     * @return
     */
    public ApiResult login(LoginDto loginDto, HttpServletRequest request, HttpServletResponse response);
}
