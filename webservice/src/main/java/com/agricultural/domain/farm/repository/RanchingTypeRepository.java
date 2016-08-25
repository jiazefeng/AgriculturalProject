package com.agricultural.domain.farm.repository;

import com.agricultural.domain.farm.model.RanchingType;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/12.
 */
public interface RanchingTypeRepository extends BaseRepository<RanchingType> {
    /**
     * 新增畜牧类型
     *
     * @param ranchingType
     * @return
     */
    public boolean addRanchingType(RanchingType ranchingType);

    /**
     * 编辑畜牧类型
     *
     * @param ranchingType
     * @return
     */
     boolean editRanchingType(RanchingType ranchingType);

    /**
     * 删除畜牧类型
     *
     * @param ranchingType
     * @return
     */
     boolean deleteRanchingType(RanchingType ranchingType);

    /**
     * 检索畜牧类型列表
     *
     * @return
     */
     List<RanchingType> searchRanchingTypeList();

    /**
     * 检索总条数
     *
     * @return
     */
     int searchTotal();

    /**
     * 按照id 检索畜牧信息
     *
     * @param id
     * @return
     */
    RanchingType searchRanchingType(String id);

    /**
     * 检索所有畜牧类型
     *
     * @return
     */
     List<RanchingType> searchRanchingType();

    /**
     * 检索畜牧父类
     *
     * @return
     */
     List<RanchingType> searchRanchingParentTypeList();
    List<RanchingType> queryRanchingTypeList();
}
