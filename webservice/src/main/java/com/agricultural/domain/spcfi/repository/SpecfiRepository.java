package com.agricultural.domain.spcfi.repository;

import com.agricultural.domain.news.model.News;
import com.agricultural.domain.spcfi.model.Specfi;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29 0029.
 */
public interface SpecfiRepository extends BaseRepository<Specfi> {
    /**
     * 增加规范
     * @return
     */
    public boolean addSpecfi(Specfi specfi);
    /**
     * 查询规范列表
     *
     * @return
     */
    public List<Specfi> searchSpecfiList();
    /**
     * 编辑规范
     */
    public boolean editSpecfi(Specfi specfi);
    /**
     * 查询规范总条数
     */
    public int searchSpecfiCount();
    /**
     * 根据id查询
     */
    public Specfi searchSpecfiBySpecfiId(String specfiId);

}
