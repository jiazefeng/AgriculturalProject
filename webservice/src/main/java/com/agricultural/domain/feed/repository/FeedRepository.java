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
     *
     * @return
     */
    List<FeedInfo> getFeedInfoList();

    /**
     * 总条数
     */
    int getCount();

    /**
     * 添加饲料
     *
     * @param feedInfo
     */
    boolean addFeed(FeedInfo feedInfo);

    /**
     * 根据ID 检索饲料信息
     *
     * @param id
     * @return
     */
    FeedInfo searchFeedById(String id);

    /**
     * 编辑饲料信息
     *
     * @param feedInfo
     * @return
     */
    boolean editFeed(FeedInfo feedInfo);

    /**
     * 删除
     * @param feedInfo
     * @return
     */
    boolean deleteFeed(FeedInfo feedInfo);
}
