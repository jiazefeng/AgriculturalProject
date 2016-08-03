package com.agricultural.domain.FunctionMenu.repository;

import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.hibernate.BaseRepository;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/02.
 */
public interface FunctionRepository extends BaseRepository<FunctionMenu>{
    /**
     * 现在功能
     * @param functionMenu
     * @return
     */
    public boolean addFunction(FunctionMenu functionMenu);

    /**
     * 检索全部功能
     * @return
     */
    public List<FunctionMenu> searchFunction();
    /**
     * 检索全部功能列表
     * @return
     */
    public List<FunctionMenu> searchFunctionList();

    /**
     * 根据功能检索对应的功能信息
     * @param mId
     * @return
     */
    public FunctionMenu searchFunctionMenuByMid(String mId);

    public int searchTotal();

}
