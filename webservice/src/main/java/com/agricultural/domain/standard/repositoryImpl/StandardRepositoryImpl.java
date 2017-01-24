package com.agricultural.domain.standard.repositoryImpl;

import com.agricultural.domain.standard.model.StandardEntity;
import com.agricultural.domain.standard.repository.StandardRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Talent on 2017/1/24.
 */
@Repository
public class StandardRepositoryImpl extends BaseRepositoryImpl<StandardEntity> implements StandardRepository {
    @Override
    public List<StandardEntity> searchStandardList() {
        List<Object> params = new ArrayList<Object>();
        String hql = "from StandardEntity where 1=1";
        return this.findByQueryList(hql, new PageInfoTools(), params);
    }

    @Override
    public int getCount() {
        List<Criterion> sql = new ArrayList<Criterion>();
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public List<StandardEntity> searchStandardListByItem(int index) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from StandardEntity where 1=1";
        return this.findByQueryList(hql, new PageInfoTools(index, 10), params);
    }

    @Override
    public StandardEntity searchStandardById(String id) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from StandardEntity where 1=1 and standardId = ?";
        params.add(id);
        return this.findByQueryResult(hql, params);
    }

    @Override
    public boolean addStandard(StandardEntity standardEntity) {
        this.save(standardEntity);
        return true;
    }

    @Override
    public boolean editStandard(StandardEntity standardEntity) {
        this.update(standardEntity);
        return true;
    }

    @Override
    public boolean deleteStandard(StandardEntity standardEntity) {
        this.deletePhysical(standardEntity);
        return true;
    }
}
