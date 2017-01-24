package com.agricultural.service.standard.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.ErrorApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.breed.dto.BreedDTO;
import com.agricultural.domain.standard.dto.StandardDTO;
import com.agricultural.domain.standard.model.StandardEntity;
import com.agricultural.domain.standard.repository.StandardRepository;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.standard.inf.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Talent on 2017/1/24.
 */
@Service
public class StandardServiceImpl implements StandardService {
    @Autowired
    StandardRepository standardRepository;

    @Override
    public ApiResult searchStandardList() {
        try {
            ModelMap result = new ModelMap();
            List<StandardEntity> standardEntities = standardRepository.searchStandardList();
            int count = standardRepository.getCount();
            result.addAttribute("count", count);
            result.addAttribute("standardEntities", standardEntities);
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }

    @Override
    public ApiResult searchStandardListByItem(StandardDTO standardDTO) {
        try {
            ModelMap result = new ModelMap();
            List<StandardEntity> standardEntities = standardRepository.searchStandardListByItem(standardDTO.getIndex());
            int count = standardRepository.getCount();
            result.addAttribute("count", count);
            result.addAttribute("standardEntities", standardEntities);
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }

    @Override
    public ApiResult searchStandardById(String id) {
        try {
            ModelMap result = new ModelMap();
            StandardEntity standardEntity = standardRepository.searchStandardById(id);
            if (standardEntity != null) {
                result.addAttribute("standardInfo", standardEntity);
            }
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }

    @Override
    public ApiResult addStandard(StandardDTO standardDTO, UserInfo userInfos) {
        try {
            ModelMap result = new ModelMap();
            if (standardDTO != null) {
                StandardEntity standardEntity = new StandardEntity();
                standardEntity.setStandardId(IdGen.uuid());
                standardEntity.setStandardNum(standardDTO.getStandardNum());
                standardEntity.setStandardTitle(standardDTO.getStandardTitle());
                standardEntity.setStandardDate(standardDTO.getStandardDate());
                standardEntity.setStandardUrl(standardDTO.getStandardUrl());
                standardEntity.setCreateOn(Calendar.getInstance());
                standardEntity.setCreateBy(userInfos.getuRealName());
                if (standardRepository.addStandard(standardEntity)) {
                    List<StandardEntity> standardEntities = standardRepository.searchStandardList();
                    int count = standardRepository.getCount();
                    result.addAttribute("count", count);
                    result.addAttribute("standardEntities", standardEntities);
                    result.addAttribute("success", "添加成功");
                } else {
                    result.addAttribute("error", "添加失败");
                }
            }
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }

    @Override
    public ApiResult editStandard(StandardDTO standardDTO, UserInfo userInfos) {
        try {
            ModelMap result = new ModelMap();
            StandardEntity standardEntity = standardRepository.searchStandardById(standardDTO.getStandardId());
            if (standardEntity != null) {
                standardEntity.setStandardNum(standardDTO.getStandardNum());
                standardEntity.setStandardTitle(standardDTO.getStandardTitle());
                standardEntity.setStandardDate(standardDTO.getStandardDate());
                standardEntity.setStandardUrl(standardDTO.getStandardUrl());
                standardEntity.setModifyBy(userInfos.getuRealName());
                standardEntity.setModifyOn(Calendar.getInstance());
                if (standardRepository.editStandard(standardEntity)) {
                    List<StandardEntity> standardEntities = standardRepository.searchStandardList();
                    result.addAttribute("standardEntities", standardEntities);
                    result.addAttribute("success", "编辑成功");
                } else {
                    result.addAttribute("error", "编辑失败");
                }
            }
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }

    @Override
    public ApiResult deleteStandard(String id) {
        try {
            ModelMap result = new ModelMap();
            StandardEntity standardEntity = standardRepository.searchStandardById(id);
            if (standardEntity != null) {
                if (standardRepository.deleteStandard(standardEntity)) {
                    result.addAttribute("success", "删除成功");
                } else {
                    result.addAttribute("error", "删除失败");
                }
            }
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }
}
