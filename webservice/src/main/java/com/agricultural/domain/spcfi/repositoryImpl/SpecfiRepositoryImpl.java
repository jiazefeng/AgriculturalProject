package com.agricultural.domain.spcfi.repositoryImpl;


import com.agricultural.domain.spcfi.model.Specfi;
import com.agricultural.domain.spcfi.repository.SpecfiRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 2016/5/9 15:56.
 * Describe:The demo repositoryImpl.
 */
@Repository
public class SpecfiRepositoryImpl extends BaseRepositoryImpl<Specfi> implements SpecfiRepository {

    @Override
    public boolean addSpecfi(Specfi specfi) {
        this.save(specfi);
        return true;
    }

    @Override
    public List<Specfi> searchSpecfiList() {
        List<Object> params = new ArrayList<Object>();
        String hql = "from Specfi";
//        params.add(1);
        List<Specfi> specfiInfoList = this.findByQueryList(hql,new PageInfoTools(),params);
        return specfiInfoList;
    }

    @Override
    public boolean editSpecfi(Specfi specfi) {
        this.update(specfi);
        return true;
    }

    @Override
    public int searchSpecfiCount() {
        List<Criterion> sql = new ArrayList<Criterion>();
//        sql.add(Restrictions.eq("uState", 1));
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public Specfi searchSpecfiBySpecfiId(String specfiId) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from Specfi as n where n.specfiId = ?";
        params.add(specfiId);
        return (Specfi)this.findObjectByQueryResult(hql,params);
    }


}
