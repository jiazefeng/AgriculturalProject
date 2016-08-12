package com.agricultural.domain.farm.repositoryImpl;

import com.agricultural.domain.farm.model.RanchingType;
import com.agricultural.domain.farm.repository.RanchingTypeRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxrocky on 2016/08/12.
 */
@Repository
public class RanchingTypeRepositoryImpl extends BaseRepositoryImpl<RanchingType> implements RanchingTypeRepository {
    @Override
    public boolean addRanchingType(RanchingType ranchingType) {
        this.save(ranchingType);
        return true;
    }

    @Override
    public boolean editRanchingType(RanchingType ranchingType) {
        this.update(ranchingType);
        return true;
    }

    @Override
    public boolean deleteRanchingType(RanchingType ranchingType) {
        this.deletePhysical(ranchingType);
        return true;
    }

    @Override
    public List<RanchingType> searchRanchingTypeList() {
        List<Object> paramas = new ArrayList<Object>();
        String sql = "FROM RanchingType as rt where rt.rtState = 1";
        List<RanchingType> ranchingTypeList = this.findByQueryList(sql, new PageInfoTools(),paramas);
        return ranchingTypeList;
    }

    @Override
    public int searchTotal() {
        List<Criterion> sql = new ArrayList<Criterion>();
        sql.add(Restrictions.eq("rtState", 1));
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public RanchingType searchRanchingType(String id) {
        List<Object> paramas = new ArrayList<Object>();
        String sql = "FROM RanchingType as rt where rt.rtState = 1 and rt.rtId=?";
        paramas.add(id);
        return (RanchingType) this.findObjectByQueryResult(sql, paramas);
    }

    @Override
    public List<RanchingType> searchRanchingType() {
        List<Object> paramas = new ArrayList<Object>();
        String sql = "FROM RanchingType as rt where rt.rtState = 1";
        List<RanchingType> ranchingTypeList = this.findByQueryList(sql,paramas);
        return ranchingTypeList;
    }
}
