package com.agricultural.service.ill.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.ill.dto.IllDTO;
import com.agricultural.domain.user.model.UserInfo;

/**
 * Created by Administrator on 2017/1/24 0024.
 */
public interface IllService {
    /**
     * 查询列表
     *
     * @return
     */
    ApiResult getIllInfoList();

    /**
     * 按条件查询列表
     *
     * @return
     */
    ApiResult getIllInfoList(IllDTO illDTO);

    /**
     * 根据Id查询信息
     *
     * @param id
     * @return
     */
    ApiResult getIllInfoById(String id);

    /**
     * 添加信息
     *
     * @param illDTO
     * @param userInfos
     * @return
     */
    ApiResult addIllInfo(IllDTO illDTO, UserInfo userInfos);

    /**
     * 编辑信息
     *
     * @param illDTO
     * @param userInfos
     * @return
     */
    ApiResult editIllInfo(IllDTO illDTO, UserInfo userInfos);

    /**
     * 删除信息
     *
     * @param id
     * @return
     */
    ApiResult deleteIllInfo(String id);

}
