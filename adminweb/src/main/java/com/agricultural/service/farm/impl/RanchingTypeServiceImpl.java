package com.agricultural.service.farm.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.farm.dto.RanchingTypeDto;
import com.agricultural.domain.farm.dto.RanchingTypeInfoDTO;
import com.agricultural.domain.farm.model.RanchingType;
import com.agricultural.domain.farm.repository.RanchingTypeRepository;
import com.agricultural.service.farm.inf.RanchingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiazefeng on 2016/08/12.
 */
@Service
public class RanchingTypeServiceImpl implements RanchingTypeService {
    @Autowired
    private RanchingTypeRepository ranchingTypeRepository;

    @Override
    public ApiResult addRanchingType(RanchingTypeDto ranchingTypeDto) {
        ModelMap modelMap = new ModelMap();
        if (ranchingTypeDto != null) {
            RanchingType ranchingType = new RanchingType();
            ranchingType.setRtId(IdGen.uuid());
            ranchingType.setRtName(ranchingTypeDto.getRtName());
            ranchingType.setRtNumber(ranchingTypeDto.getRtNumber());
            ranchingType.setRtImge(ranchingTypeDto.getRtImge());
            ranchingType.setRtState(1);
            ranchingType.setRtProfile(ranchingTypeDto.getRtProfile());
            ranchingType.setRtParentId(ranchingTypeDto.getRtParentId());
            ranchingType.setRtLevel(ranchingTypeDto.getRtLevel());
            if (ranchingTypeRepository.addRanchingType(ranchingType)) {
//                List<RanchingType> ranchingTypeList = ranchingTypeRepository.searchRanchingTypeList();
               List<RanchingTypeDto> ranchingTypeDtoList = searchRachingTypeDto();
                int count = ranchingTypeRepository.searchTotal();

                modelMap.addAttribute("count", count);
                modelMap.addAttribute("ranchingTypeList", ranchingTypeDtoList);
                modelMap.addAttribute("success", "添加成功");
            } else {
                modelMap.addAttribute("error", "添加失败");
            }

        } else {
            modelMap.addAttribute("error", "信息不完整");
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult editRanchingType(RanchingTypeDto ranchingTypeDto) {
        ModelMap modelMap = new ModelMap();
        if (ranchingTypeDto != null) {
            RanchingType ranchingType = ranchingTypeRepository.searchRanchingType(ranchingTypeDto.getRtId());
            if (ranchingType != null) {
                ranchingType.setRtNumber(ranchingTypeDto.getRtNumber());
                ranchingType.setRtName(ranchingTypeDto.getRtName());
                ranchingType.setRtImge(ranchingTypeDto.getRtImge());
                ranchingType.setRtProfile(ranchingTypeDto.getRtProfile());
                ranchingType.setRtParentId(ranchingTypeDto.getRtParentId());
                ranchingType.setRtLevel(ranchingTypeDto.getRtLevel());
                if (ranchingTypeRepository.editRanchingType(ranchingType)) {
//                    List<RanchingType> ranchingTypeList = ranchingTypeRepository.searchRanchingTypeList();
                    List<RanchingTypeDto> ranchingTypeDtoList = searchRachingTypeDto();
                    modelMap.addAttribute("ranchingTypeList", ranchingTypeDtoList);
                    modelMap.addAttribute("success", "编辑成功");
                } else {
                    modelMap.addAttribute("error", "编辑失败");
                }
            }

        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult deleteRanchingType(String id) {
        ModelMap modelMap = new ModelMap();
        if (id != null) {
            RanchingType ranchingType = ranchingTypeRepository.searchRanchingType(id);
            if (ranchingType != null) {
                ranchingType.setRtState(0);
                if (ranchingTypeRepository.editRanchingType(ranchingType)) {
                    modelMap.addAttribute("success", "删除成功");
                } else {
                    modelMap.addAttribute("error", "删除失败");
                }
            }
        }
        return new SuccessApiResult(modelMap);
    }



    @Override
    public ApiResult searchRanchingTypeList() {
        ModelMap modelMap = new ModelMap();
//        List<RanchingType> ranchingTypeList = new ArrayList<RanchingType>();
//        ranchingTypeList = ranchingTypeRepository.searchRanchingTypeList();
        List<RanchingTypeDto> ranchingTypeDtoList = searchRachingTypeDto();
        int count = ranchingTypeRepository.searchTotal();
        modelMap.addAttribute("count", count);
        modelMap.addAttribute("ranchingTypeList", ranchingTypeDtoList);
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult searchRanchingType() {
        ModelMap modelMap = new ModelMap();
        List<RanchingType> ranchingTypeList = new ArrayList<RanchingType>();
        ranchingTypeList = ranchingTypeRepository.searchRanchingType();
        modelMap.addAttribute("ranchingTypeList", ranchingTypeList);
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult searchRanchingTypeInfo(String id) {
        ModelMap modelMap = new ModelMap();
        if (id != null) {
            RanchingType ranchingType = ranchingTypeRepository.searchRanchingType(id);
            if (ranchingType != null) {
                modelMap.addAttribute("ranchingType", ranchingType);
            }
            List<RanchingTypeInfoDTO> ranchingTypeInfoDTOList = searchRanchingTypeInfo();
            if (ranchingTypeInfoDTOList != null && ranchingTypeInfoDTOList.size() > 0) {
                modelMap.addAttribute("ranchingTypeList", ranchingTypeInfoDTOList);
            }
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult searchRanchingParentTypeList() {
        ModelMap modelMap = new ModelMap();
        List<RanchingType> ranchingTypeList = ranchingTypeRepository.searchRanchingParentTypeList();
        if (ranchingTypeList != null && ranchingTypeList.size() > 0) {
            modelMap.addAttribute("ranchingTypeList", ranchingTypeList);
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public List<RanchingTypeInfoDTO> searchRanchingTypeInfo() {
        List<RanchingType> ranchingTypeList = ranchingTypeRepository.searchRanchingParentTypeList();
        List<RanchingTypeInfoDTO> ranchingTypeInfoDTOList = new ArrayList<RanchingTypeInfoDTO>();
        if (ranchingTypeList != null && ranchingTypeList.size() > 0) {
            for (RanchingType ranchingType : ranchingTypeList) {
                RanchingTypeInfoDTO ranchingTypeInfoDTO = new RanchingTypeInfoDTO();
                ranchingTypeInfoDTO.setId(ranchingType.getRtId());
                ranchingTypeInfoDTO.setName(ranchingType.getRtName());

                ranchingTypeInfoDTOList.add(ranchingTypeInfoDTO);
            }
        }
        return ranchingTypeInfoDTOList;
    }

    @Override
    public List<RanchingTypeDto> searchRachingTypeDto() {
        List<RanchingType> ranchingTypeList = ranchingTypeRepository.searchRanchingTypeList();
        List<RanchingTypeDto> ranchingTypeDtoList = new ArrayList<RanchingTypeDto>();
        if (ranchingTypeList != null && ranchingTypeList.size() > 0) {
            for (RanchingType ranchingType : ranchingTypeList) {
                RanchingTypeDto ranchingTypeDto = new RanchingTypeDto();
                ranchingTypeDto.setRtId(ranchingType.getRtId());
                ranchingTypeDto.setRtNumber(ranchingType.getRtNumber());
                ranchingTypeDto.setRtName(ranchingType.getRtName());
                ranchingTypeDto.setRtImge(ranchingType.getRtImge());
                ranchingTypeDto.setRtProfile(ranchingType.getRtProfile());
                ranchingTypeDto.setRtLevel(ranchingType.getRtLevel());
                if (ranchingType.getRtParentId() != null && !ranchingType.getRtParentId().equals("")) {
                    RanchingType ranchingType1 = ranchingTypeRepository.searchRanchingType(ranchingType.getRtParentId());
                    ranchingTypeDto.setRtParentName(ranchingType1.getRtName());
                }
                ranchingTypeDtoList.add(ranchingTypeDto);
            }
        }
        return ranchingTypeDtoList;
    }

    @Override
    public List<RanchingTypeInfoDTO> queryRanchingTypeInf() {
        List<RanchingType> ranchingTypeList = ranchingTypeRepository.queryRanchingTypeList();
        List<RanchingTypeInfoDTO> ranchingTypeInfoDTOList = new ArrayList<RanchingTypeInfoDTO>();
        if(ranchingTypeList != null && ranchingTypeList.size()>0){
            for(RanchingType ranchingType : ranchingTypeList){
                RanchingTypeInfoDTO ranchingTypeInfoDTO = new RanchingTypeInfoDTO();
                ranchingTypeInfoDTO.setId(ranchingType.getRtId());
                ranchingTypeInfoDTO.setName(ranchingType.getRtName());

                ranchingTypeInfoDTOList.add(ranchingTypeInfoDTO);
            }
        }
        return ranchingTypeInfoDTOList;
    }

    @Override
    public ApiResult queryRanchingTypeList() {
        ModelMap modelMap = new ModelMap();
        List<RanchingTypeInfoDTO> ranchingTypeInfoDTOList = queryRanchingTypeInf();
        modelMap.addAttribute("ranchingTypeList",ranchingTypeInfoDTOList);
        return new SuccessApiResult(modelMap);
    }
}
