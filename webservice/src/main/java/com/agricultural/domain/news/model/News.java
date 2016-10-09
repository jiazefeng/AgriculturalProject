package com.agricultural.domain.news.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;


/**
 * Created by Administrator on 2016/9/17 0017.
 */
@Entity
@Table(name = "NEWS")
public class  News extends BaseVO {
    /**
     * 新闻id
     */
    private String newId;
    /**
     *新闻标题
     */
    private String newTitle;
    /**
     * 新闻发布时间
     */
    private String newTime;
    /**
     * 新闻作者
     */
    private String newOther;
    /**
     * 新闻内容
     */
    private String newContent;

    @Id
    @Column(name = "NEW_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    @Basic
    @Column(name = "NEW_TITLE", nullable = false, insertable = true, updatable = true, length = 32)
    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    @Basic
    @Column(name = "NEW_TIME", nullable = false, insertable = true, updatable = true, length = 32)
    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    @Basic
    @Column(name = "NEW_OTHER", nullable = false, insertable = true, updatable = true, length = 32)
    public String getNewOther() {
        return newOther;
    }

    public void setNewOther(String newOther) {
        this.newOther = newOther;
    }

    @Basic
    @Column(name = "NEW_CONTENT", nullable = false, insertable = true, updatable = true, length = 32)
    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }
}
