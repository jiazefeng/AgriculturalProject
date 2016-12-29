package com.agricultural.domain.news.repository;

import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.news.model.News;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17 0017.
 */
public interface NewsRepository extends BaseRepository<News> {
    /**
     * 增加新闻
     * @return
     */
    public boolean addNews(News news);
    /**
     * 查询新闻列表
     *
     * @return
     */
    public List<News> searchNewList();
    /**
     * 编辑新闻
     */
    public boolean editNew(News news);
    /**
     * 查询 新闻总条数
     */
    public int searchNewsCount();
    /**
     * 根据id查询
     */
    public News searchNewsByNewsId(String newId);

}
