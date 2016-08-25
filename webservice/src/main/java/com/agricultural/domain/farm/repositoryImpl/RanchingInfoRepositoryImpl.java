package com.agricultural.domain.farm.repositoryImpl;

import com.agricultural.domain.farm.model.RanchingInfo;
import com.agricultural.domain.farm.repository.RanchingInfoRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiazefeng on 2016/08/24.
 */
@Repository
public class RanchingInfoRepositoryImpl extends BaseRepositoryImpl<RanchingInfo> implements RanchingInfoRepository {
    @Override
    public boolean addRanchingInfo(RanchingInfo ranchingInfo) {
        this.save(ranchingInfo);
        return true;
    }

    @Override
    public boolean editRanchingInfo(RanchingInfo ranchingInfo) {
        this.update(ranchingInfo);
        return true;
    }

    @Override
    public boolean deleteRanchingInfo(RanchingInfo ranchingInfo) {
        this.deletePhysical(ranchingInfo);
        return true;
    }

    @Override
    public RanchingInfo searchRanchingInfo(String id) {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM RanchingInfo AS ri WHERE ri.riState = 1 AND ri.riId = ? ";
        params.add(id);
        return (RanchingInfo) this.findObjectByQueryResult(hql, params);
    }

    @Override
    public List<RanchingInfo> searchRanchingInfoList() {
        List<Object> paramas = new ArrayList<Object>();
        String sql = "FROM RanchingInfo AS ri WHERE ri.riState = 1";
        List<RanchingInfo> ranchingInfoList = this.findByQueryList(sql, paramas);
        return ranchingInfoList;
    }

    @Override
    public int searchTotal() {
        List<Criterion> sql = new ArrayList<Criterion>();
        sql.add(Restrictions.eq("riState", 1));
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public int searchTotalByItem(RanchingInfo ranchingInfo) {
        List<Criterion> sql = new ArrayList<Criterion>();

        sql.add(Restrictions.eq("riState", 1));
        if (ranchingInfo.getRiNumber() != null && !ranchingInfo.getRiNumber().equals("")) {
            sql.add(Restrictions.eq("riNumber", ranchingInfo.getRiNumber()));
        }
        if (ranchingInfo.getRiName() != null && !ranchingInfo.getRiName().equals("")) {
            sql.add(Restrictions.like("riName", ranchingInfo.getRiName()));
        }
        if (ranchingInfo.getRanchingTypeId() != null && !ranchingInfo.getRanchingTypeId().equals("")) {
            sql.add(Restrictions.eq("ranchingTypeId", ranchingInfo.getRanchingTypeId()));
        }
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public List<RanchingInfo> searchRanchingInfoByItem(RanchingInfo ranchingInfo, int startRow) {
        List<Object> paramas = new ArrayList<Object>();
        String hql = "FROM RanchingInfo AS ri WHERE ri.riState = 1";
        if (ranchingInfo.getRiNumber() != null && !ranchingInfo.getRiNumber().equals("")) {
            hql += " AND ri.riNumber = '" + ranchingInfo.getRiNumber() + "'";
        }
        if (ranchingInfo.getRiName() != null && !ranchingInfo.getRiName().equals("")) {
            hql += " AND ri.riName LIKE '%" + ranchingInfo.getRiName() + "%'";
        }
        if (ranchingInfo.getRanchingTypeId() != null && !ranchingInfo.getRanchingTypeId().equals("")) {
            hql += " AND ri.ranchingTypeId = '" + ranchingInfo.getRanchingTypeId() + "'";
        }
        List<RanchingInfo> ranchingInfoList = this.findByQueryList(hql, new PageInfoTools(startRow, 10), paramas);
        return ranchingInfoList;
    }
}
