package com.agricultural.domain.feed.repositoryImpl;

import com.agricultural.domain.feed.model.FeedInfo;
import com.agricultural.domain.feed.repository.FeedRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Talent on 2016/12/29.
 */
@Repository
public class FeedRepositoryImpl extends BaseRepositoryImpl<FeedInfo> implements FeedRepository {
    @Override
    public List<FeedInfo> getFeedInfoList() {
        List<Object> params = new ArrayList<Object>();
        String hql = "from FeedInfo as f ";
        List<FeedInfo> feedInfoList = this.findByQueryList(hql,new PageInfoTools(),params);
        return feedInfoList;
    }

    @Override
    public List<FeedInfo> getFeedInfoList(int index) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from FeedInfo as f ";
        List<FeedInfo> feedInfoList = this.findByQueryList(hql,new PageInfoTools(index,10),params);
        return feedInfoList;
    }

    @Override
    public int getCount() {
        List<Criterion> sql = new ArrayList<Criterion>();
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public boolean addFeed(FeedInfo feedInfo) {
        this.save(feedInfo);
        return true;
    }

    @Override
    public FeedInfo searchFeedById(String id) {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM FeedInfo as m where m.feedId=? ";
        params.add(id);

        return (FeedInfo) this.findObjectByQueryResult(hql, params);
    }

    @Override
    public boolean editFeed(FeedInfo feedInfo) {
        this.update(feedInfo);
        return true;
    }

    @Override
    public boolean deleteFeed(FeedInfo feedInfo) {
        this.deletePhysical(feedInfo);
        return true;
    }
}
