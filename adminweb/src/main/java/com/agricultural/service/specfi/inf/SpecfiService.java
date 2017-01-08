package com.agricultural.service.specfi.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.news.dto.NewDTO;
import com.agricultural.domain.spcfi.dto.SpecfiDTO;

/**
 * Created by Administrator on 2017/1/3 0003.
 */
public interface SpecfiService {
    /**
     * 添加新闻
     */
    public ApiResult addSpecfi(SpecfiDTO specfiDTO);
    /**
     * 查询新闻列表
     */
    public ApiResult searchSpecfiInfoList();
}
