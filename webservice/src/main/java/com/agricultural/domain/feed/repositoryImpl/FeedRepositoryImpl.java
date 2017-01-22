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
    public int getCount() {
//        List<Criterion> sql = new ArrayList<Criterion>();
        return this.findByCriteriaForPageCount();
    }
}
