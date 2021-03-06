package com.agricultural.domain.news.model;

import com.agricultural.hibernate.BaseVO;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Administrator on 2016/9/17 0017.
 */
@Entity
@Table(name = "NEWS")
public class News extends BaseVO {
    /**
     * 新闻id
     */
    private String newId;
    /**
     * 新闻标题
     */
    private String newTitle;
    /**
     * 新闻发布时间
     */
    private Date newTime;
    /**
     * 新闻作者
     */
    private String newOther;
    /**
     * 新闻内容
     */
    private String newContent;

    /**
     * 新闻简介
     *
     * @return
     */
    private String newIntro;
    /**
     * 其他相关新闻链接
     *
     * @return
     */
    private String otherNew;

    @Id
    @Column(name = "NEW_ID", nullable = false, insertable = true, updatable = true, length = 32)
    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    @Basic
    @Column(name = "NEW_TITLE", nullable = true, insertable = true, updatable = true, length = 100)
    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    @Basic
    @Column(name = "NEW_TIME", nullable = true)
    public Date getNewTime() {
        return newTime;
    }

    public void setNewTime(Date newTime) {
        this.newTime = newTime;
    }

    @Basic
    @Column(name = "NEW_OTHER", nullable = true, insertable = true, updatable = true, length = 32)
    public String getNewOther() {
        return newOther;
    }

    public void setNewOther(String newOther) {
        this.newOther = newOther;
    }

    @Basic
    @Column(name = "NEW_CONTENT", nullable = true, insertable = true, updatable = true, length = 500)
    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    @Basic
    @Column(name = "NEW_INTRO", nullable = true, insertable = true, updatable = true, length = 100)
    public String getNewIntro() {
        return newIntro;
    }

    public void setNewIntro(String newIntro) {
        this.newIntro = newIntro;
    }

    @Basic
    @Column(name = "OTHER_NEW", nullable = true, insertable = true, updatable = true, length = 100)
    public String getOtherNew() {
        return otherNew;
    }

    public void setOtherNew(String otherNew) {
        this.otherNew = otherNew;
    }
}
