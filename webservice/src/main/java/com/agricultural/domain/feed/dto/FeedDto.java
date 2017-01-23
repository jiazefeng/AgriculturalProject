package com.agricultural.domain.feed.dto;

import com.agricultural.page.PageInfoTools;

/**
 * Created by Talent on 2016/12/30.
 */
public class FeedDto extends PageInfoTools{
    private String feedId;
    private String feedName;
    private String describe;
    private String type;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
