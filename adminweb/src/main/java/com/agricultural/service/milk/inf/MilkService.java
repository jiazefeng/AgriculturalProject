package com.agricultural.service.milk.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.milk.dto.MilkDTO;
import com.agricultural.domain.user.model.UserInfo;

/**
 * Created by Talent on 2017/1/23.
 */
public interface MilkService {
    /**
     * 查询列表
     *
     * @return
     */
    ApiResult getMilkInfoList();

    /**
     * 按条件查询列表
     *
     * @return
     */
    ApiResult getMilkInfoList(MilkDTO milkDTO);

    /**
     * 根据Id查询信息
     *
     * @param id
     * @return
     */
    ApiResult getMilkInfoById(String id);

    /**
     * 添加信息
     *
     * @param milkDTO
     * @param userInfos
     * @return
     */
    ApiResult addMilkInfo(MilkDTO milkDTO, UserInfo userInfos);

    /**
     * 编辑信息
     *
     * @param milkDTO
     * @param userInfos
     * @return
     */
    ApiResult editMilkInfo(MilkDTO milkDTO, UserInfo userInfos);

    /**
     * 删除信息
     *
     * @param id
     * @return
     */
    ApiResult deleteMilkInfo(String id);

}
