package com.agricultural.service.standard.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.breed.dto.BreedDTO;
import com.agricultural.domain.standard.dto.StandardDTO;
import com.agricultural.domain.user.model.UserInfo;

/**
 * Created by Talent on 2017/1/24.
 */
public interface StandardService {
    /**
     * 检索全部信息
     *
     * @return
     */
    ApiResult searchStandardList();

    /**
     * 按条件检索信息
     *
     * @param standardDTO
     * @return
     */
    ApiResult searchStandardListByItem(StandardDTO standardDTO);

    /**
     * 根据Id检索信息
     *
     * @param id
     * @return
     */
    ApiResult searchStandardById(String id);

    /**
     * 添加信息
     *
     * @param standardDTO
     * @param userInfos
     * @return
     */
    ApiResult addStandard(StandardDTO standardDTO, UserInfo userInfos);

    /**
     * 编辑信息
     *
     * @param standardDTO
     * @param userInfos
     * @return
     */
    ApiResult editStandard(StandardDTO standardDTO, UserInfo userInfos);

    /**
     * 删除信息
     *
     * @param id
     * @return
     */
    ApiResult deleteStandard(String id);

}
