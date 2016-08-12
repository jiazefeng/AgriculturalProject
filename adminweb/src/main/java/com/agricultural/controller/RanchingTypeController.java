package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.farm.dto.RanchingTypeDto;
import com.agricultural.domain.farm.model.RanchingType;
import com.agricultural.service.farm.inf.RanchingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiazefneg on 2016/08/12.
 */
@RestController
@RequestMapping(value = "/ranchingType")
public class RanchingTypeController {
    @Autowired
    private RanchingTypeService ranchingTypeService;

    /**
     * 初始化检索畜牧类型
     *
     * @return
     */
    @RequestMapping(value = "/searchRanchingTypeList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchRanchingTypeList() {
        return ranchingTypeService.searchRanchingTypeList();
    }

    /**
     * 添加畜牧类型
     *
     * @param ranchingTypeDto
     * @return
     */
    @RequestMapping(value = "/addRanchingType", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addRanchingType(@RequestBody RanchingTypeDto ranchingTypeDto) {
        return ranchingTypeService.addRanchingType(ranchingTypeDto);
    }
    /**
     * 按照id检索畜牧类型
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/searchRanchingTypeById/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchRanchingTypeById(@PathVariable("id") String id) {
        return ranchingTypeService.searchRanchingTypeInfo(id);
    }

    /**
     * 编辑畜牧类型
     *
     * @param ranchingTypeDto
     * @return
     */
    @RequestMapping(value = "/editRanchingType", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editRanchingType(@RequestBody RanchingTypeDto ranchingTypeDto) {
        return ranchingTypeService.editRanchingType(ranchingTypeDto);
    }

    /**
     * 删除畜牧类型
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteRanchingType/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.DELETE)
    public ApiResult deleteRanchingType(@PathVariable("id") String id) {
        return ranchingTypeService.deleteRanchingType(id);
    }
}
