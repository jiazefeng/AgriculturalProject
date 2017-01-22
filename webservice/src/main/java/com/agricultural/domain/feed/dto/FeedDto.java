package com.agricultural.domain.feed.dto;

/**
 * Created by Talent on 2016/12/30.
 */
public class FeedDto {
    private String feedName;
    private String describe;
    private String type;

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
