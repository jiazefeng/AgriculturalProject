package com.agricultural.controller;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.role.dto.RoleInfoDto;
import com.agricultural.service.function.inf.FunctionService;
import com.agricultural.service.role.inf.RoleInfoService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jiazefeng on 2016/08/02.
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private FunctionService functionService;

    /**
     * 检索全部角色列表
     *
     * @return
     */
    @RequestMapping(value = "/searchRoleList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchRoleList() {
        return roleInfoService.searchRoleInfoList();
    }

    /**
     * 添加角色
     *
     * @return
     */
    @RequestMapping(value = "/addRole", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public ApiResult addRole(@RequestBody RoleInfoDto roleInfoDto) {
        return roleInfoService.addRole(roleInfoDto);
    }

    /**
     * 根据ID检索角色信息
     *
     * @return
     */
    @RequestMapping(value = "/searchRoleInfoByRoleId/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResult searchRoleInfoByRoleId(@PathVariable("id") String id) {
        return roleInfoService.searchRoleInfoById(id);
    }

    /**
     * 编辑角色信息
     *
     * @return
     */
    @RequestMapping(value = "/editRoleInfo", produces = "application/json;UTF-8", method = RequestMethod.POST)
    public ApiResult editRoleInfo(@RequestBody RoleInfoDto roleInfoDto) {
        return roleInfoService.editRoleInfo(roleInfoDto);
    }

    /**
     * 检索全部角色信息
     *
     * @return
     */
@RequestMapping(value = "/searchRoleInfo" ,produces = "application/json;UTF-8", method = RequestMethod.GET)
    public ApiResult searchRoleInfo() {
        return roleInfoService.searchRoleInfo();
}
}
