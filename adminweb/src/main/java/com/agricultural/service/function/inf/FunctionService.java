package com.agricultural.service.function.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/02.
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

    /**
     * 初始化检索功能列表
     *
     * @return
     */
    public ApiResult searFunctionList();

    /**
     * 根据功能id 检索功能信息
     *
     * @param mId
     * @return
     */
    public ApiResult searchFunction(String mId);

    /**
     * 编辑功能
     *
     * @param functionMenuDTO
     * @return
     */
    public ApiResult editFunction(FunctionMenuDTO functionMenuDTO);

    /**
     * 按条件检索功能信息列表
     *
     * @param functionMenuDTO
     * @return
     */
    public ApiResult searFunctionListByItem(FunctionMenuDTO functionMenuDTO);

    /**
     * 删除功能信息
     *
     * @param id
     * @return
     */
    public ApiResult deleteFunction(String id);

    /**
     * 检索功能菜单
     *
     * @return
     */
    public List<FunctionMenuDTO> searchFunctionMenu();
}
