package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.farm.dto.RanchingInfoDTO;
import com.agricultural.domain.farm.dto.RanchingTypeDto;
import com.agricultural.domain.farm.model.RanchingInfo;
import com.agricultural.service.farm.inf.RanchingInfoService;
import com.agricultural.service.farm.inf.RanchingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jiazefneg on 2016/08/12.
 */
@RestController
@RequestMapping(value = "/ranchingInfo")
public class RanchingInfoController {
    @Autowired
    private RanchingInfoService ranchingInfoService;

    /**
     * 初始化检索畜牧列表
     *
     * @return
     */
    @RequestMapping(value = "/searchRanchingInfoList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchRanchingInfoList() {

        return ranchingInfoService.searchRanchingInfoList();
    }

    /**
     * 添加畜牧
     *
     * @param ranchingInfoDto
     * @return
     */
    @RequestMapping(value = "/addRanchingInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addRanchingInfo(@RequestBody RanchingInfoDTO ranchingInfoDto) {
        return ranchingInfoService.addRanchingInfo(ranchingInfoDto);
    }

    /**
     * 按照id检索畜牧
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/searchRanchingInfById/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchRanchingInfById(@PathVariable("id") String id) {
        return ranchingInfoService.searchRanchingInfoById(id);
    }

    /**
     * 编辑畜牧
     *
     * @param ranchingInfoDTO
     * @return
     */
    @RequestMapping(value = "/editRanchingInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editRanchingInfo(@RequestBody RanchingInfoDTO ranchingInfoDTO) {
        return ranchingInfoService.editRanchingInfo(ranchingInfoDTO);
    }

    /**
     * 删除畜牧
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteRanchingInfo/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.DELETE)
    public ApiResult deleteRanchingInfo(@PathVariable("id") String id) {
        return ranchingInfoService.deleteRanchingInfo(id);
    }

    /**
     * 按条件检索畜牧列表
     *
     * @param ranchingInfoDTO
     * @return
     */
    @RequestMapping(value = "/searchRanchingInfoByItem", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult searchRanchingInfoByItem(@RequestBody RanchingInfoDTO ranchingInfoDTO) {
        return ranchingInfoService.searchRanchingInfoByItem(ranchingInfoDTO);
    }
}
