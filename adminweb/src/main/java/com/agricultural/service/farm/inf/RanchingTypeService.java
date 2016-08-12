package com.agricultural.service.farm.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.farm.dto.RanchingTypeDto;
import com.agricultural.domain.farm.model.RanchingType;

/**
 * Created by jiazefeng on 2016/08/12.
 */

public interface RanchingTypeService {
    /**
     * 新增畜牧类型
     *
     * @param ranchingTypeDto
     * @return
     */
    public ApiResult addRanchingType(RanchingTypeDto ranchingTypeDto);

    /**
     * 编辑畜牧类型
     *
     * @param ranchingTypeDto
     * @return
     */
    public ApiResult editRanchingType(RanchingTypeDto ranchingTypeDto);

    /**
     * 删除畜牧类型
     *
     * @param id
     * @return
     */
    public ApiResult deleteRanchingType(String id);

    /**
     * 检索畜牧类型列表
     *
     * @return
     */
    public ApiResult searchRanchingTypeList();

    /**
     * 检索所有畜牧类型
     *
     * @return
     */
    public ApiResult searchRanchingType();

    /**
     * 按照id 检索畜牧类型信息
     *
     * @param id
     * @return
     */
    public ApiResult searchRanchingTypeInfo(String id);
}
