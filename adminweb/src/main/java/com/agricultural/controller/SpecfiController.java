package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.news.dto.NewDTO;
import com.agricultural.domain.spcfi.dto.SpecfiDTO;
import com.agricultural.service.news.inf.NewService;
import com.agricultural.service.specfi.inf.SpecfiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/1/3 0003.
 */
@RestController
@RequestMapping(value = "/specfi")
public class SpecfiController {
    @Autowired
    private SpecfiService specfiService;
    /**
     * 添加
     */
    @RequestMapping(value = "/addSpecfi", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addNew(@RequestBody SpecfiDTO specfiDTO) {
        return specfiService.addSpecfi(specfiDTO);
    }
    /**
     * 查询
     */
    @RequestMapping(value = "/searchSpecfiList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchSpecfiList() {
        return specfiService.searchSpecfiInfoList();
    }
    /**
     * 修改列表
     */
    @RequestMapping(value="/updateSpecfi",produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
    public  ApiResult updateSpecfi(@RequestBody SpecfiDTO specfiDTO) {
        return null;
    }
    
}
