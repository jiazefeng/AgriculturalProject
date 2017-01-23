package com.agricultural.domain.milk.repository;

import com.agricultural.domain.milk.model.MilkEntity;

import java.util.List;

/**
 * Created by Talent on 2017/1/23.
 */
public interface MilkRepository {
    /**
     * 查询总条数
     *
     * @return
     */
    int getCount();

    /**
     * 查询列表
     *
     * @return
     */
    List<MilkEntity> getMilkInfoList(int index);

    /**
     * 查询列表
     *
     * @return
     */
    List<MilkEntity> getMilkInfoList();
    /**
     * 根据ID查询信息
     *
     * @param id
     * @return
     */
    MilkEntity getMilkInfoById(String id);

    /**
     * 添加信息
     *
     * @param milkEntity
     * @return
     */
    boolean addMilkInfo(MilkEntity milkEntity);

    /**
     * 编辑信息
     *
     * @param milkEntity
     * @return
     */
    boolean editMilkInfo(MilkEntity milkEntity);

    /**
     * 删除信息
     *
     * @param milkEntity
     * @return
     */
    boolean deleteMilkInfo(MilkEntity milkEntity);
}
