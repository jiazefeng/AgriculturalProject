package com.agricultural.service.breed.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.breed.dto.BreedDTO;
import com.agricultural.domain.user.model.UserInfo;

/**
 * Created by Talent on 2017/1/24.
 */
public interface BreedService {
    /**
     * 初始化检索全部列表信息
     *
     * @return
     */
    ApiResult searBreedList();

    /**
     * 按天剑检索列表信息
     *
     * @param breedDTO
     * @return
     */
    ApiResult searBreedListByItem(BreedDTO breedDTO);

    /**
     * 根据ID 检索信息
     *
     * @param id
     * @return
     */
    ApiResult searchBreedById(String id);

    /**
     * 添加信息
     *
     * @param breedDTO
     * @return
     */
    ApiResult addBreed(BreedDTO breedDTO,UserInfo userInfo);

    /**
     * 编辑信息
     *
     * @param breedDTO
     * @return
     */
    ApiResult editBreed(BreedDTO breedDTO,UserInfo userInfo);

    /**
     * 删除信息
     *
     * @param id
     * @return
     */
    ApiResult deleteBreed(String id);
}
