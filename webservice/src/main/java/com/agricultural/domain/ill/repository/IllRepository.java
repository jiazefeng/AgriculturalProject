package com.agricultural.domain.ill.repository;

import com.agricultural.domain.ill.model.ComminIll;
import java.util.List;

/**
 * Created by Administrator on 2017/1/24 0024.
 */
public interface IllRepository {
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
    List<ComminIll> getIllInfoList(int index);

    /**
     * 查询列表
     *
     * @return
     */
    List<ComminIll> getIllInfoList();
    /**
     * 根据ID查询信息
     *
     * @param id
     * @return
     */
    ComminIll getIllInfoById(String id);

    /**
     * 添加信息
     *
     * @param comminIll
     * @return
     */
    boolean addIllInfo(ComminIll comminIll);

    /**
     * 编辑信息
     *
     * @param comminIll
     * @return
     */
    boolean editIllInfo(ComminIll comminIll);

    /**
     * 删除信息
     *
     * @param comminIll
     * @return
     */
    boolean deleteIllInfo(ComminIll comminIll);
}
