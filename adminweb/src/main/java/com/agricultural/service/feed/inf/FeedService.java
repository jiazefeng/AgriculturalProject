package com.agricultural.service.feed.inf;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.feed.dto.FeedDto;
import com.agricultural.domain.user.model.UserInfo;

/**
 * Created by Talent on 2016/12/29.
 */
public interface FeedService {
    /**
     * 饲料列表
     *
     * @return
     */
    ApiResult getFeedInfoList();

    /**
     * 添加 饲料
     *
     * @param feedDto
     * @return
     */
    ApiResult addFeed(FeedDto feedDto,UserInfo userInfos);

    /**
     * 根据Id 检索饲料信息
     *
     * @param id
     * @return
     */
    ApiResult searchFeedById(String id);

    /**
     * 编辑饲料信息
     *
     * @param feedDto
     * @return
     */
    ApiResult editFeed(FeedDto feedDto,UserInfo userInfos);

    /**
     * 删除
     * @param id
     * @return
     */
    ApiResult deleteFunction(String id);
}
