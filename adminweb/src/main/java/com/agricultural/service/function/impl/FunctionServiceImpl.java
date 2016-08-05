package com.agricultural.service.function.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.dto.MenuDto;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.FunctionMenu.repository.FunctionRepository;
import com.agricultural.service.function.inf.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jiazefeng on 2016/08/02.
 */
@Service
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private FunctionRepository functionRepository;


    @Override
    public ApiResult addFunction(FunctionMenuDTO functionMenuDTO) {
        ModelMap result = new ModelMap();
        if (functionMenuDTO != null) {
            FunctionMenu functionMenu = new FunctionMenu();

            functionMenu.setmId(IdGen.uuid());
            functionMenu.setmName(functionMenuDTO.getmName());
            functionMenu.setmIfNavigationNode(functionMenuDTO.getmIfNavigationNode());
            functionMenu.setmLayer(functionMenuDTO.getmLayer());
            functionMenu.setmOrder(functionMenuDTO.getmOrder());
            functionMenu.setmUrl(functionMenuDTO.getmUrl());
            functionMenu.setmState(1);
            functionMenu.setCreateOn(Calendar.getInstance());
            functionMenu.setmParentId(functionMenuDTO.getmParentId());

            if (functionRepository.addFunction(functionMenu)) {
                result.addAttribute("success", "添加成功");
            } else {
                result.addAttribute("error", "添加失败");
            }
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult searFunction() {
        List<FunctionMenu> functionMenuList = functionRepository.searchFunction();
        List<MenuDto> menuDtos = new ArrayList<MenuDto>();
        if (functionMenuList != null && functionMenuList.size() > 0) {
            for (FunctionMenu functionMenu : functionMenuList) {
                MenuDto menuDto = new MenuDto();
                menuDto.setmId(functionMenu.getmId());
                menuDto.setmName(functionMenu.getmName());

                menuDtos.add(menuDto);
            }
        }
        return new SuccessApiResult(menuDtos);
    }

    @Override
    public ApiResult searFunctionList() {
        List<FunctionMenu> functionMenuList = functionRepository.searchFunctionList();
        List<FunctionMenuDTO> functionMenuDTOList = new ArrayList<FunctionMenuDTO>();
        if (functionMenuList != null && functionMenuList.size() > 0) {
            for (FunctionMenu functionMenu : functionMenuList) {
                FunctionMenuDTO functionMenuDTO = new FunctionMenuDTO();
                functionMenuDTO.setmId(functionMenu.getmId());
                functionMenuDTO.setmName(functionMenu.getmName());
                functionMenuDTO.setmUrl(functionMenu.getmUrl());
                functionMenuDTO.setmLayer(functionMenu.getmLayer());
                functionMenuDTO.setmOrder(functionMenu.getmOrder());
                functionMenuDTO.setmIfNavigationNode(functionMenu.getmIfNavigationNode());
                if (functionMenu.getmParentId() != null) {
                    FunctionMenu functionMenu1 = functionRepository.searchFunctionMenuByMid(functionMenu.getmId());
                    functionMenuDTO.setmParentName(functionMenu1.getmName());
                }
                functionMenuDTOList.add(functionMenuDTO);
            }
        }
        int count = functionRepository.searchTotal();
        ModelMap result = new ModelMap();
        result.addAttribute("count", count);
        result.addAttribute("menuList", functionMenuDTOList);
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult searchFunction(String mId) {

        List<FunctionMenu> functionMenuList = functionRepository.searchFunction();
        List<MenuDto> menuDtos = new ArrayList<MenuDto>();
        if (functionMenuList != null && functionMenuList.size() > 0) {
            for (FunctionMenu functionMenu : functionMenuList) {
                MenuDto menuDto = new MenuDto();
                menuDto.setmId(functionMenu.getmId());
                menuDto.setmName(functionMenu.getmName());

                menuDtos.add(menuDto);
            }
        }

        FunctionMenu functionMenu = functionRepository.searchFunctionMenuByMid(mId);

        ModelMap result = new ModelMap();
        result.addAttribute("functionList", menuDtos);
        result.addAttribute("functionInfo", functionMenu);

        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult editFunction(FunctionMenuDTO functionMenuDTO) {
        ModelMap result = new ModelMap();
        if (functionMenuDTO != null) {
            FunctionMenu functionMenu = functionRepository.searchFunctionMenuByMid(functionMenuDTO.getmId());

            functionMenu.setmName(functionMenuDTO.getmName());
            functionMenu.setmIfNavigationNode(functionMenuDTO.getmIfNavigationNode());
            functionMenu.setmLayer(functionMenuDTO.getmLayer());
            functionMenu.setmOrder(functionMenuDTO.getmOrder());
            functionMenu.setmUrl(functionMenuDTO.getmUrl());
            functionMenu.setCreateOn(Calendar.getInstance());
            functionMenu.setmParentId(functionMenuDTO.getmParentId());

            if (functionRepository.editFunction(functionMenu)) {
                result.addAttribute("success", "编辑成功");
            } else {
                result.addAttribute("error", "编辑失败");
            }
        } else {
            result.addAttribute("error", "编辑失败");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult searFunctionListByItem(FunctionMenuDTO functionMenuDTO) {
        List<FunctionMenu> functionMenuList = functionRepository.searchFunctionListByItem(functionMenuDTO.getIndex());
        List<FunctionMenuDTO> functionMenuDTOList = new ArrayList<FunctionMenuDTO>();
        if (functionMenuList != null && functionMenuList.size() > 0) {
            for (FunctionMenu functionMenu : functionMenuList) {
                FunctionMenuDTO functionMenuDTO1 = new FunctionMenuDTO();
                functionMenuDTO1.setmId(functionMenu.getmId());
                functionMenuDTO1.setmName(functionMenu.getmName());
                functionMenuDTO1.setmUrl(functionMenu.getmUrl());
                functionMenuDTO1.setmLayer(functionMenu.getmLayer());
                functionMenuDTO1.setmOrder(functionMenu.getmOrder());
                functionMenuDTO1.setmIfNavigationNode(functionMenu.getmIfNavigationNode());
                if (functionMenu.getmParentId() != null) {
                    FunctionMenu functionMenu1 = functionRepository.searchFunctionMenuByMid(functionMenu.getmId());
                    functionMenuDTO1.setmParentName(functionMenu1.getmName());
                }
                functionMenuDTOList.add(functionMenuDTO1);
            }
        }
        int count = functionRepository.searchTotal();
        ModelMap result = new ModelMap();
        result.addAttribute("count", count);
        result.addAttribute("page", functionMenuDTO.getIndex());
        result.addAttribute("menuList", functionMenuDTOList);
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult deleteFunction(String id) {
        ModelMap result = new ModelMap();
        FunctionMenu functionMenu = functionRepository.searchFunctionMenuByMid(id);
        if (functionMenu != null) {
            functionMenu.setmState(0);
            if (functionRepository.editFunction(functionMenu)) {
                result.addAttribute("success", "删除成功");
            } else {
                result.addAttribute("error", "删除失败");
            }
        } else {
            result.addAttribute("error", "该条信息不存在");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public List<FunctionMenuDTO> searchFunctionMenu() {
        //所有导航菜单
        List<FunctionMenu> mainMenuList = functionRepository.searchMainMenu();
        List<FunctionMenuDTO> functionMenuDTOList = new ArrayList<FunctionMenuDTO>();
        if (mainMenuList != null && mainMenuList.size() > 0) {
            for (FunctionMenu mainMenu : mainMenuList) {
                FunctionMenuDTO functionMenuDTO = new FunctionMenuDTO();
                List<FunctionMenu> twoLevelMenuList =functionRepository.searchTwoLevelMenu(mainMenu.getmId());
                functionMenuDTO.setmId(mainMenu.getmId());
                functionMenuDTO.setmName(mainMenu.getmName());
                if(twoLevelMenuList != null && twoLevelMenuList.size()>0){
                    functionMenuDTO.setAllSubmenuList(twoLevelMenuList);
                }
                functionMenuDTOList.add(functionMenuDTO);
            }
        }
        return functionMenuDTOList;
    }
}
