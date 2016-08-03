package com.agricultural.service.function.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;

/**
 * Created by maxrocky on 2016/08/02.
 */
public interface FunctionService {
    /**
     * 添加功能
     *
     * @param functionMenuDTO
     * @return
     */
    public ApiResult addFunction(FunctionMenuDTO functionMenuDTO);

    /**
     * 检索全部功能
     *
     * @return
     */
    public ApiResult searFunction();

   public  ApiResult searFunctionList();
}
