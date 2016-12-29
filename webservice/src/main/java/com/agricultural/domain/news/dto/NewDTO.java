package com.agricultural.domain.news.dto;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class NewDTO {
    private String newTitle;
    private Date newTime;
    private String newOther;
    private String newContent;
    private String newIntro;
    private String newLink;

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public Date getNewTime() {
        return newTime;
    }

    public void setNewTime(Date newTime) {
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

    public String getNewIntro() {
        return newIntro;
    }

    public void setNewIntro(String newIntro) {
        this.newIntro = newIntro;
    }

    public String getNewLink() {
        return newLink;
    }

    public void setNewLink(String newLink) {
        this.newLink = newLink;
    }
}
