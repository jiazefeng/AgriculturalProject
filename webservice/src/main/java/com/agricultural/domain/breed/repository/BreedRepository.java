package com.agricultural.domain.breed.repository;

import com.agricultural.domain.breed.model.BreedEntity;

import java.util.List;

/**
 * Created by Talent on 2017/1/24.
 */
public interface BreedRepository {
    /**
     * 检索全部列表信息
     *
     * @return
     */
    List<BreedEntity> searBreedList();

    /**
     * 总数
     *
     * @return
     */
    int getCount();

    /**
     * 按天剑检索列表信息
     *
     * @param index
     * @return
     */
    List<BreedEntity> searBreedListByItem(int index);

    /**
     * 根据id检索信息
     *
     * @param id
     * @return
     */
    BreedEntity searchBreedById(String id);

    /**
     * 添加信息
     *
     * @param breedEntity
     * @return
     */
    boolean addBreed(BreedEntity breedEntity);

    /**
     * 编辑信息
     *
     * @param breedEntity
     * @return
     */
    boolean editBreed(BreedEntity breedEntity);

    /**
     * 删除信息
     *
     * @param breedEntity
     * @return
     */
    boolean deleteBreed(BreedEntity breedEntity);
}
