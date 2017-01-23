package com.agricultural.domain.milk.repositoryImpl;

import com.agricultural.domain.milk.model.MilkEntity;
import com.agricultural.domain.milk.repository.MilkRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Talent on 2017/1/23.
 */
@Repository
public class MilkRepositoryImpl extends BaseRepositoryImpl<MilkEntity> implements MilkRepository {
    @Override
    public int getCount() {
        List<Criterion> sql = new ArrayList<Criterion>();
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public List<MilkEntity> getMilkInfoList(int index) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from MilkEntity as m where 1=1 ";
        List<MilkEntity> feedInfoList = this.findByQueryList(hql, new PageInfoTools(index,10), params);
        return feedInfoList;
    }

    @Override
    public List<MilkEntity> getMilkInfoList() {
        List<Object> params = new ArrayList<Object>();
        String hql = "from MilkEntity as m where 1=1 ";
        List<MilkEntity> feedInfoList = this.findByQueryList(hql, new PageInfoTools(), params);
        return feedInfoList;
    }

    @Override
    public MilkEntity getMilkInfoById(String id) {
        List<Object> params = new ArrayList<Object>();
        String hql = "FROM MilkEntity as m where m.milkId=? ";
        params.add(id);

        return (MilkEntity) this.findObjectByQueryResult(hql, params);
    }

    @Override
    public boolean addMilkInfo(MilkEntity milkEntity) {
        this.save(milkEntity);
        return true;
    }

    @Override
    public boolean editMilkInfo(MilkEntity milkEntity) {
        this.update(milkEntity);
        return true;
    }

    @Override
    public boolean deleteMilkInfo(MilkEntity milkEntity) {
        this.deletePhysical(milkEntity);
        return true;
    }
}
