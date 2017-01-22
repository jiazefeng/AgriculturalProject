package com.agricultural.domain.feed.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;

/**
 * Created by Talent on 2016/12/29.
 */
@Entity
@Table(name = "FEED_INFO")
public class FeedInfo extends BaseVO {
    private String feedId;
    private String feedName;
    private String describe;
    private String type;

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
    @Column(name = "DESCRIBE", nullable = true, length = 500)
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "TYPE", nullable = true, length = 64)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
