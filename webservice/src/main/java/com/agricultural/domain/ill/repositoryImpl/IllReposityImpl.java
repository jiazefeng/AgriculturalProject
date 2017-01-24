package com.agricultural.domain.ill.repositoryImpl;

import com.agricultural.domain.ill.model.ComminIll;
import com.agricultural.domain.ill.repository.IllRepository;
import com.agricultural.domain.milk.model.MilkEntity;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/24 0024.
 */
@Repository
public class IllReposityImpl extends BaseRepositoryImpl<ComminIll> implements IllRepository {
        @Override
        public int getCount() {
                List<Criterion> sql = new ArrayList<Criterion>();
                return this.findByCriteriaForPageCount(sql);
        }

        @Override
        public List<ComminIll> getIllInfoList(int index) {
                List<Object> params = new ArrayList<Object>();
                String hql = "from ComminIll as m where 1=1 ";
                List<ComminIll> illInfoList = this.findByQueryList(hql, new PageInfoTools(index,10), params);
                return illInfoList;
        }

        @Override
        public List<ComminIll> getIllInfoList() {
                List<Object> params = new ArrayList<Object>();
                String hql = "from ComminIll as m where 1=1 ";
                List<ComminIll> illInfoList = this.findByQueryList(hql, new PageInfoTools(), params);
                return illInfoList;
        }

        @Override
        public ComminIll getIllInfoById(String id) {
                List<Object> params = new ArrayList<Object>();
                String hql = "FROM ComminIll as m where m.illId=? ";
                params.add(id);

                return (ComminIll) this.findObjectByQueryResult(hql, params);
        }

        @Override
        public boolean addIllInfo(ComminIll comminIll) {
                this.save(comminIll);
                return true;
        }

        @Override
        public boolean editIllInfo(ComminIll comminIll) {
                this.update(comminIll);
                return true;
        }

        @Override
        public boolean deleteIllInfo(ComminIll comminIll) {
                this.deletePhysical(comminIll);
                return true;
        }
}
