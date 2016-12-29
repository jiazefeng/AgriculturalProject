package com.agricultural.service.basic;

import com.agricultural.common.result.ApiResult;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
public interface BaiscService<T> {
    /**
     * 基本查询方法
     * @return ApiResult
     */
    public ApiResult basicSreach();
}
