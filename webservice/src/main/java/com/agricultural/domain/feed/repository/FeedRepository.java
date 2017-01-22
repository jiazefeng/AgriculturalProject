package com.agricultural.domain.feed.repository;

import com.agricultural.domain.feed.model.FeedInfo;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by Talent on 2016/12/29.
 */
public interface FeedRepository extends BaseRepository<FeedInfo> {
    /**
     * 饲料列表
     * @return
     */
    List<FeedInfo> getFeedInfoList();
    /**
     * 总条数
     */
    int getCount();
}
