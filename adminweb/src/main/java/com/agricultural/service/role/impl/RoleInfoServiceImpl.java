package com.agricultural.service.role.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.FunctionMenu.repository.FunctionRepository;
import com.agricultural.domain.role.dto.RoleDTO;
import com.agricultural.domain.role.dto.RoleInfoDto;
import com.agricultural.domain.role.model.RoleFunction;
import com.agricultural.domain.role.model.RoleInfo;
import com.agricultural.domain.role.repository.RoleFunctionRepository;
import com.agricultural.domain.role.repository.RoleInfoRepository;
import com.agricultural.service.function.impl.FunctionServiceImpl;
import com.agricultural.service.role.inf.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by jiazefeng on 2016/08/05.
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    private RoleInfoRepository roleInfoRepository;
    @Autowired
    private RoleFunctionRepository roleFunctionRepository;
    @Autowired
    private FunctionRepository functionRepository;

    @Override
    public ApiResult searchRoleInfoList() {
        List<RoleInfo> roleInfoList = roleInfoRepository.searchRoleInfoList();
        int count = roleInfoRepository.searchTotal();
        ModelMap result = new ModelMap();
        result.addAttribute("count", count);
        result.addAttribute("roleInfoList", roleInfoList);
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult addRole(RoleInfoDto roleInfoDto) {
        ModelMap result = new ModelMap();
        if (roleInfoDto != null) {
            RoleInfo roleInfo = new RoleInfo();
            roleInfo.setrId(IdGen.uuid());
            roleInfo.setrName(roleInfoDto.getrName());
            roleInfo.setrState(roleInfoDto.getrState());
            if (roleInfoRepository.addRole(roleInfo)) {
                if (roleInfoDto.getFunctionMenus() != null && roleInfoDto.getFunctionMenus().size() > 0) {
                    List<LinkedHashMap<String, String>> functionMenus = roleInfoDto.getFunctionMenus();
                    List<RoleFunction> rolefunctionList = new ArrayList<RoleFunction>();
                    for (int i = 0; i < functionMenus.size(); i++) {
                        RoleFunction roleFunction = new RoleFunction();
                        roleFunction.setRfId(IdGen.uuid());
                        roleFunction.setRoleId(roleInfo.getrId());
                        LinkedHashMap<String, String> map = functionMenus.get(i);
                        roleFunction.setFuncId(map.get("id"));
                        rolefunctionList.add(roleFunction);
                    }
                    if (rolefunctionList != null && rolefunctionList.size() > 0) {
                        for (RoleFunction roleFunction : rolefunctionList) {
                            if (roleFunctionRepository.addRoleFunction(roleFunction)) {
                                result.addAttribute("success", "添加成功");
                            } else {
                                result.addAttribute("error", "添加失败");
                            }
                        }
                    } else {
                        result.addAttribute("error", "请为该角色选择权限");
                    }
                } else {
                    result.addAttribute("error", "请为该角色选择权限");
                }
            } else {
                result.addAttribute("error", "添加失败");
            }
        } else {
            result.addAttribute("error", "参数错误");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult searchRoleInfoById(String id) {
        ModelMap result = new ModelMap();
        if (id != null) {
            RoleInfo roleInfo = roleInfoRepository.get(id);
            if (roleInfo != null) {
                List<RoleFunction> roleFunctionList = roleFunctionRepository.roleFunctionList(roleInfo.getrId());
                if (roleFunctionList != null && roleFunctionList.size() > 0) {
                    result.addAttribute("roleFunctionList", roleFunctionList);
                }
                result.addAttribute("roleInfo", roleInfo);
            }
        }
        List<FunctionMenuDTO> functionMenuList = searchFunctionMenu();
        result.addAttribute("menuList", functionMenuList);
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult editRoleInfo(RoleInfoDto roleInfoDto) {
        ModelMap result = new ModelMap();
        if (roleInfoDto != null) {
            RoleInfo roleInfo = roleInfoRepository.get(roleInfoDto.getrId());
            if (roleInfo != null) {
                roleInfo.setrName(roleInfoDto.getrName());
                roleInfo.setrState(roleInfoDto.getrState());
                if (roleInfoRepository.editRole(roleInfo)) {
                    List<RoleFunction> roleFunctionList = roleFunctionRepository.roleFunctionList(roleInfoDto.getrId());
                    if (roleFunctionList != null && roleFunctionList.size() > 0) {
                        if (roleFunctionRepository.deleteRoleFunction(roleFunctionList)) {
                            if (roleInfoDto.getFunctionMenus() != null && roleInfoDto.getFunctionMenus().size() > 0) {
                                List<LinkedHashMap<String, String>> functionMenus = roleInfoDto.getFunctionMenus();
                                List<RoleFunction> rolefunctionList = new ArrayList<RoleFunction>();
                                for (int i = 0; i < functionMenus.size(); i++) {
                                    RoleFunction roleFunction = new RoleFunction();
                                    roleFunction.setRfId(IdGen.uuid());
                                    roleFunction.setRoleId(roleInfo.getrId());
                                    LinkedHashMap<String, String> map = functionMenus.get(i);
                                    roleFunction.setFuncId(map.get("id"));
                                    rolefunctionList.add(roleFunction);
                                }
                                if (rolefunctionList != null && rolefunctionList.size() > 0) {
                                    for (RoleFunction roleFunction : rolefunctionList) {
                                        if (roleFunctionRepository.addRoleFunction(roleFunction)) {
                                            result.addAttribute("success", "编辑成功");
                                        } else {
                                            result.addAttribute("error", "编辑失败");
                                        }
                                    }
                                } else {
                                    result.addAttribute("error", "请为该角色选择权限");
                                }
                            } else {
                                result.addAttribute("error", "请为该角色选择权限");
                            }
                        } else {
                            result.addAttribute("error", "编辑失败");
                        }
                    } else {
                        if (roleInfoDto.getFunctionMenus() != null && roleInfoDto.getFunctionMenus().size() > 0) {
                            List<LinkedHashMap<String, String>> functionMenus = roleInfoDto.getFunctionMenus();
                            List<RoleFunction> rolefunctionList = new ArrayList<RoleFunction>();
                            for (int i = 0; i < functionMenus.size(); i++) {
                                RoleFunction roleFunction = new RoleFunction();
                                roleFunction.setRfId(IdGen.uuid());
                                roleFunction.setRoleId(roleInfo.getrId());
                                LinkedHashMap<String, String> map = functionMenus.get(i);
                                roleFunction.setFuncId(map.get("id"));
                                rolefunctionList.add(roleFunction);
                            }
                            if (rolefunctionList != null && rolefunctionList.size() > 0) {
                                for (RoleFunction roleFunction : rolefunctionList) {
                                    if (roleFunctionRepository.addRoleFunction(roleFunction)) {
                                        result.addAttribute("success", "编辑成功");
                                    } else {
                                        result.addAttribute("error", "编辑失败");
                                    }
                                }
                            } else {
                                result.addAttribute("error", "请为该角色选择权限");
                            }
                        } else {
                            result.addAttribute("error", "请为该角色选择权限");
                        }
                    }
                } else {
                    result.addAttribute("error", "编辑失败");
                }
            } else {
                result.addAttribute("error", "未发现需要修改的角色");
            }
        } else {
            result.addAttribute("error", "参数错误");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult searchRoleInfo() {
        List<RoleInfo> roleInfoList = roleInfoRepository.searchRoleInfo();
        List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>();
        if (roleInfoList != null && roleInfoList.size() > 0) {
            for(RoleInfo roleInfo : roleInfoList){
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setRoleId(roleInfo.getrId());
                roleDTO.setRoleName(roleInfo.getrName());
                roleDTOList.add(roleDTO);
            }
        }
        ModelMap result = new ModelMap();
        result.addAttribute("roleInfo", roleDTOList);
        return new SuccessApiResult(result);
    }

    public List<FunctionMenuDTO> searchFunctionMenu() {
        //所有导航菜单
        List<FunctionMenu> mainMenuList = functionRepository.searchMainMenu();
        List<FunctionMenuDTO> functionMenuDTOList = new ArrayList<FunctionMenuDTO>();
        if (mainMenuList != null && mainMenuList.size() > 0) {
            for (FunctionMenu mainMenu : mainMenuList) {
                FunctionMenuDTO functionMenuDTO = new FunctionMenuDTO();
                List<FunctionMenu> twoLevelMenuList = functionRepository.searchTwoLevelMenu(mainMenu.getmId());
                functionMenuDTO.setmId(mainMenu.getmId());
                functionMenuDTO.setmName(mainMenu.getmName());
                if (twoLevelMenuList != null && twoLevelMenuList.size() > 0) {
                    functionMenuDTO.setAllSubmenuList(twoLevelMenuList);
                }
                functionMenuDTOList.add(functionMenuDTO);
            }
        }
        return functionMenuDTOList;
    }
}
