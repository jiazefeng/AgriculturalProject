package com.agricultural.domain.feed.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * 物资信息
 * Created by Talent on 2016/12/29.
 */
@Entity
@Table(name = "FEED_INFO")
public class FeedInfo extends BaseVO {
    private String feedId;//物资ID
    private String feedName;//物资名称
    private String feedDescribe;//物资名称
    private String feedType;//物资类型

    @Id
    @Column(name = "FEED_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    @Basic
    @Column(name = "FEED_NAME", nullable = true, length = 64)
    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }
    @Basic
    @Column(name = "FEED_DESCRIBE", nullable = true, length = 500)
    public String getFeedDescribe() {
        return feedDescribe;
    }

    public void setFeedDescribe(String feedDescribe) {
        this.feedDescribe = feedDescribe;
    }

    @Basic
    @Column(name = "FEED_TYPE", nullable = true, length = 64)
    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }
}
