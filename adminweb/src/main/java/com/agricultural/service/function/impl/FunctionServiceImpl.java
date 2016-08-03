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
        result.addAttribute("count",count);
        result.addAttribute("menuList",functionMenuDTOList);
        return new SuccessApiResult(result);
    }
}
