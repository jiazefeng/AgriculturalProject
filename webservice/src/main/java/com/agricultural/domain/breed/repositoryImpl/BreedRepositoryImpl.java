package com.agricultural.domain.breed.repositoryImpl;

import com.agricultural.domain.breed.model.BreedEntity;
import com.agricultural.domain.breed.repository.BreedRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Talent on 2017/1/24.
 */
@Repository
public class BreedRepositoryImpl extends BaseRepositoryImpl<BreedEntity> implements BreedRepository {
    @Override
    public List<BreedEntity> searBreedList() {
        List<Object> params = new ArrayList<Object>();
        String hql = " from BreedEntity where 1=1";

        return this.findByQueryList(hql, new PageInfoTools(), params);
    }

    @Override
    public int getCount() {
        List<Criterion> sql = new ArrayList<Criterion>();
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public List<BreedEntity> searBreedListByItem(int index) {
        List<Object> params = new ArrayList<Object>();
        String hql = " from BreedEntity where 1=1";

        return this.findByQueryList(hql, new PageInfoTools(index, 10), params);
    }

    @Override
    public BreedEntity searchBreedById(String id) {
        List<Object> params = new ArrayList<Object>();
        String hql = " from BreedEntity where 1=1 and breedId=?";
        params.add(id);
        return (BreedEntity) this.findObjectByQueryResult(hql, params);
    }

    @Override
    public boolean addBreed(BreedEntity breedEntity) {
        this.save(breedEntity);
        return true;
    }

    @Override
    public boolean editBreed(BreedEntity breedEntity) {
        this.update(breedEntity);
        return true;
    }

    @Override
    public boolean deleteBreed(BreedEntity breedEntity) {
        this.deletePhysical(breedEntity);
        return true;
    }
}
