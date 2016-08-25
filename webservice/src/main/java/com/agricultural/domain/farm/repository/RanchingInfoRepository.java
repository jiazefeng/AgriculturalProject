package com.agricultural.domain.farm.repository;

import com.agricultural.domain.farm.model.RanchingInfo;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/24.
 */
public interface RanchingInfoRepository extends BaseRepository<RanchingInfo> {
    /**
     * 新增畜牧
     *
     * @param ranchingInfo
     * @return
     */
    boolean addRanchingInfo(RanchingInfo ranchingInfo);

    /**
     * 编辑畜牧
     *
     * @param ranchingInfo
     * @return
     */
    boolean editRanchingInfo(RanchingInfo ranchingInfo);

    /**
     * 删除畜牧
     *
     * @param ranchingInfo
     * @return
     */
    boolean deleteRanchingInfo(RanchingInfo ranchingInfo);

    /**
     * 根据id检索畜牧信息
     *
     * @param id
     * @return
     */
    RanchingInfo searchRanchingInfo(String id);

    /**
     * 检索畜牧列表
     *
     * @return
     */
    List<RanchingInfo> searchRanchingInfoList();

    /**
     * 检索总条数
     *
     * @return
     */
    int searchTotal();

    /**
     * 按条件检索总条数
     *
     * @param ranchingInfo
     * @return
     */
    int searchTotalByItem(RanchingInfo ranchingInfo);

    /**
     * 按条件检索畜牧列表
     *
     * @param ranchingInfo
     * @param startRow
     * @return
     */
    List<RanchingInfo> searchRanchingInfoByItem(RanchingInfo ranchingInfo, int startRow);
}
