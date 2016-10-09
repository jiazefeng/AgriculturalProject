package com.agricultural.domain.news.dto;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class NewDTO {
    private String newTitle;
    private String newTime;
    private String newOther;
    private String newContent;

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    public String getNewOther() {
        return newOther;
    }

    public void setNewOther(String newOther) {
        this.newOther = newOther;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }
}
