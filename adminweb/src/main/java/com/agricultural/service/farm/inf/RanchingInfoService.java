package com.agricultural.service.farm.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.farm.dto.RanchingInfoDTO;
import com.agricultural.domain.farm.model.RanchingInfo;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/24.
 */
public interface RanchingInfoService {
    List<RanchingInfoDTO> searchRanchingInfoDTOList(List<RanchingInfo> ranchingInfoList);

    ApiResult addRanchingInfo(RanchingInfoDTO ranchingInfoDTO);
    ApiResult editRanchingInfo(RanchingInfoDTO ranchingInfoDTO);
    ApiResult deleteRanchingInfo(String id);
    ApiResult searchRanchingInfoList();


    ApiResult searchRanchingInfoById(String id);

    ApiResult searchRanchingInfoByItem(RanchingInfoDTO ranchingInfoDTO);
}
