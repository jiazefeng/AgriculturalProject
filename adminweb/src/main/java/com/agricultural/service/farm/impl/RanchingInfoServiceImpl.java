package com.agricultural.service.farm.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.farm.dto.RanchingInfoDTO;
import com.agricultural.domain.farm.dto.RanchingTypeInfoDTO;
import com.agricultural.domain.farm.model.RanchingInfo;
import com.agricultural.domain.farm.model.RanchingType;
import com.agricultural.domain.farm.repository.RanchingInfoRepository;
import com.agricultural.domain.farm.repository.RanchingTypeRepository;
import com.agricultural.service.farm.inf.RanchingInfoService;
import com.agricultural.service.farm.inf.RanchingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jiezefeng on 2016/08/24.
 */
@Service
public class RanchingInfoServiceImpl implements RanchingInfoService {
    @Autowired
    private RanchingInfoRepository ranchingInfoRepository;
    @Autowired
    private RanchingTypeRepository ranchingTypeRepository;
    @Autowired
    private RanchingTypeService ranchingTypeService;

    @Override
    public List<RanchingInfoDTO> searchRanchingInfoDTOList(List<RanchingInfo> ranchingInfoList) {

        List<RanchingInfoDTO> ranchingInfoDTOList = new ArrayList<RanchingInfoDTO>();
        if (ranchingInfoList != null && ranchingInfoList.size() > 0) {
            for (RanchingInfo ranchingInfo : ranchingInfoList) {
                RanchingInfoDTO ranchingInfoDTO = new RanchingInfoDTO();
                ranchingInfoDTO.setId(ranchingInfo.getRiId());
                ranchingInfoDTO.setName(ranchingInfo.getRiName());
                ranchingInfoDTO.setNumber(ranchingInfo.getRiNumber());
                ranchingInfoDTO.setIfPregnant(ranchingInfo.getIfPregnant());
                ranchingInfoDTO.setPregnantDate(ranchingInfo.getPregnantDate());
                ranchingInfoDTO.setRiImge(ranchingInfo.getRiImge());
                ranchingInfoDTO.setRiWeight(ranchingInfo.getRiWeight());
                ranchingInfoDTO.setRiProfile(ranchingInfo.getRiProfile());
                RanchingType ranchingType = ranchingTypeRepository.searchRanchingType(ranchingInfo.getRanchingTypeId());
                if (ranchingType != null) {
                    ranchingInfoDTO.setRanchingTypeName(ranchingType.getRtName());
                }

                ranchingInfoDTOList.add(ranchingInfoDTO);
            }
        }
        return ranchingInfoDTOList;
    }

    @Override
    public ApiResult addRanchingInfo(RanchingInfoDTO ranchingInfoDTO) {
        ModelMap modelMap = new ModelMap();
        if (ranchingInfoDTO != null) {
            RanchingInfo ranchingInfo = new RanchingInfo();
            ranchingInfo.setRiId(IdGen.uuid());
            ranchingInfo.setRiState(1);
            ranchingInfo.setRiName(ranchingInfoDTO.getName());
            ranchingInfo.setRiNumber(ranchingInfoDTO.getNumber());
            ranchingInfo.setRiWeight(ranchingInfoDTO.getRiWeight());
            ranchingInfo.setRiImge(ranchingInfoDTO.getRiImge());
            ranchingInfo.setCreatDate(new Date());
            ranchingInfo.setEditDate(new Date());
            ranchingInfo.setIfPregnant(ranchingInfoDTO.getIfPregnant());
            ranchingInfo.setPregnantDate(ranchingInfoDTO.getPregnantDate());
            ranchingInfo.setRiProfile(ranchingInfoDTO.getRiProfile());
            ranchingInfo.setRanchingTypeId(ranchingInfoDTO.getRanchingTypeId());
            if (ranchingInfoRepository.addRanchingInfo(ranchingInfo)) {
                modelMap.addAttribute("success", "添加成功");
            } else {
                modelMap.addAttribute("error", "添加失败");
            }
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult editRanchingInfo(RanchingInfoDTO ranchingInfoDTO) {
        ModelMap modelMap = new ModelMap();
        if (ranchingInfoDTO != null) {
            RanchingInfo ranchingInfo = ranchingInfoRepository.searchRanchingInfo(ranchingInfoDTO.getId());
            if (ranchingInfo != null) {

                ranchingInfo.setRiName(ranchingInfoDTO.getName());
                ranchingInfo.setRiNumber(ranchingInfoDTO.getNumber());
                ranchingInfo.setRiWeight(ranchingInfoDTO.getRiWeight());
                ranchingInfo.setRiImge(ranchingInfoDTO.getRiImge());
                ranchingInfo.setIfPregnant(ranchingInfoDTO.getIfPregnant());
                ranchingInfo.setPregnantDate(ranchingInfoDTO.getPregnantDate());
                ranchingInfo.setRiProfile(ranchingInfoDTO.getRiProfile());
                ranchingInfo.setRanchingTypeId(ranchingInfoDTO.getRanchingTypeId());

                if (ranchingInfoRepository.editRanchingInfo(ranchingInfo)) {
                    modelMap.addAttribute("success", "编辑成功");
                } else {
                    modelMap.addAttribute("error", "编辑失败");
                }
            } else {
                modelMap.addAttribute("error", "没有找到要编辑的对象");
            }
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult deleteRanchingInfo(String id) {
        ModelMap modelMap = new ModelMap();
        if (id != null) {
            RanchingInfo ranchingInfo = ranchingInfoRepository.searchRanchingInfo(id);
            if (ranchingInfo != null) {
                ranchingInfo.setRiState(2);
                if (ranchingInfoRepository.editRanchingInfo(ranchingInfo)) {
                    modelMap.addAttribute("success", "删除成功");
                } else {
                    modelMap.addAttribute("error", "删除失败");
                }
            } else {
                modelMap.addAttribute("error", "对象不存在");
            }
        } else {
            modelMap.addAttribute("error", "请选择要删除的对象");
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult searchRanchingInfoList() {
        List<RanchingInfo> ranchingInfoList = ranchingInfoRepository.searchRanchingInfoList();
        List<RanchingInfoDTO> ranchingInfoDTOList = searchRanchingInfoDTOList(ranchingInfoList);
        int count = ranchingInfoRepository.searchTotal();
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("ranchingInfoList", ranchingInfoDTOList);
        modelMap.addAttribute("count", count);
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult searchRanchingInfoById(String id) {
        ModelMap modelMap = new ModelMap();
        RanchingInfo ranchingInfo = ranchingInfoRepository.searchRanchingInfo(id);
        if (ranchingInfo != null) {
            List<RanchingTypeInfoDTO> ranchingTypeInfoDTOList = ranchingTypeService.queryRanchingTypeInf();

            modelMap.addAttribute("ranchingTypeList", ranchingTypeInfoDTOList);
            modelMap.addAttribute("ranchingInf", ranchingInfo);

        } else {
            modelMap.addAttribute("error", "没有找到要编辑的对象");
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult searchRanchingInfoByItem(RanchingInfoDTO ranchingInfoDTO) {
        ModelMap modelMap = new ModelMap();
        if (ranchingInfoDTO != null) {
            RanchingInfo ranchingInfo = new RanchingInfo();
            ranchingInfo.setRanchingTypeId(ranchingInfoDTO.getRanchingTypeId());
            ranchingInfo.setRiNumber(ranchingInfoDTO.getNumber());
            ranchingInfo.setRiName(ranchingInfoDTO.getName());

            List<RanchingInfo> ranchingInfoList = ranchingInfoRepository.searchRanchingInfoByItem(ranchingInfo, ranchingInfoDTO.getIndex());
            List<RanchingInfoDTO> ranchingInfoDTOList = searchRanchingInfoDTOList(ranchingInfoList);

            int count = ranchingInfoRepository.searchTotalByItem(ranchingInfo);
            modelMap.addAttribute("count", count);
            modelMap.addAttribute("ranchingInfoList", ranchingInfoDTOList);
        }
        return new SuccessApiResult(modelMap);
    }
}
