package com.agricultural.domain.standard.repository;

import com.agricultural.domain.standard.model.StandardEntity;

import java.util.List;

/**
 * Created by Talent on 2017/1/24.
 */
public interface StandardRepository {
    /**
     * 查询全部信息
     * @return
     */
    List<StandardEntity> searchStandardList();

    /**
     *总数
     * @return
     */
    int getCount();

    /**
     * 按条件查询信息
     * @param index
     * @return
     */
    List<StandardEntity> searchStandardListByItem(int index);

    /**
     * 根据ID查询信息
     * @param id
     * @return
     */
    StandardEntity searchStandardById(String id);

    boolean addStandard(StandardEntity standardEntity);

    boolean editStandard(StandardEntity standardEntity);

    boolean deleteStandard(StandardEntity standardEntity);
}
