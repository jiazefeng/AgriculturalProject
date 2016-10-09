package com.agricultural.domain.news.repositoryImpl;

import com.agricultural.domain.news.model.News;
import com.agricultural.domain.news.repository.NewsRepository;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2016/9/17 0017.
 */
@Repository
public class NewsRepositoryImpl extends BaseRepositoryImpl<News> implements NewsRepository {
    @Override
    public boolean addNews(News news) {
        this.save(news);
        return true;
    }

    @Override
    public List<News> searchNewList() {
        List<Object> params = new ArrayList<Object>();
        String hql = "from News as u where u.newTitle = ?";
        params.add(1);
        List<News> newInfoList = this.findByQueryList(hql,new PageInfoTools(),params);
        return newInfoList;

    }

    @Override
    public boolean editNew(News news) {
        this.update(news);
        return true;
    }

    @Override
    public int searchNewsCount() {
        List<Criterion> sql = new ArrayList<Criterion>();
        sql.add(Restrictions.eq("uState", 1));
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public News searchNewsByNewsId(String newId) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from News as n where n.newId = ?";
        params.add(newId);
        return (News)this.findObjectByQueryResult(hql,params);
    }


}
