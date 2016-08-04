package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.service.function.inf.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiazefeng on 2016/08/02.
 */
@RestController
@RequestMapping(value = "/function")
public class FunctionContruller {
    @Autowired
    private FunctionService functionService;


    /**
     * 添加的时候检索全部功能
     *
     * @return
     */
    @RequestMapping(value = "/searFunction", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searFunction() {
        return functionService.searFunction();
    }

    /**
     * 添加功能
     *
     * @return
     */
    @RequestMapping(value = "/addFunction", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addFunction(@RequestBody FunctionMenuDTO functionMenuDTO) {
        return functionService.addFunction(functionMenuDTO);
    }

    /**
     * 初始化检索全部功能列表
     *
     * @return
     */
    @RequestMapping(value = "/searFunctionList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searFunctionList() {
        return functionService.searFunctionList();
    }

    /**
     * 根据id查询功能信息
     */
    @RequestMapping(value = "/searchFunctionById/id", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchFunctionById(@PathVariable String id){
        return functionService.searchFunction(id);
    }
    /**
     * 编辑功能
     *
     * @return
     */
    @RequestMapping(value = "/editFunction", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult editFunction(@RequestBody FunctionMenuDTO functionMenuDTO) {
        return functionService.editFunction(functionMenuDTO);
    }
}
