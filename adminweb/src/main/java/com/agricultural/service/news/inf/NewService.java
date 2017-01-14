package com.agricultural.service.news.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.news.dto.NewDTO;
import com.agricultural.domain.news.model.News;
import com.agricultural.domain.user.model.UserInfo;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public interface NewService {
    /**
     * 添加新闻
     */
    public ApiResult addNew(NewDTO newDTO);
    /**
     * 查询新闻列表
     */
    public ApiResult searchNewsInfoList();
/**
 * 编辑新闻
 */
public  ApiResult editNew(NewDTO newDTO);
}
