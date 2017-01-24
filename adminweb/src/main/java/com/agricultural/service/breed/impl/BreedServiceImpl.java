package com.agricultural.service.breed.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.ErrorApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.breed.dto.BreedDTO;
import com.agricultural.domain.breed.model.BreedEntity;
import com.agricultural.domain.breed.repository.BreedRepository;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.breed.inf.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Talent on 2017/1/24.
 */
@Service
public class BreedServiceImpl implements BreedService {
    @Autowired
    BreedRepository breedRepository;

    @Override
    public ApiResult searBreedList() {
        ModelMap result = new ModelMap();
        try {
            List<BreedEntity> breedEntities = breedRepository.searBreedList();
            int count = breedRepository.getCount();
            result.addAttribute("count", count);
            result.addAttribute("breedInfoList", breedEntities);
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }

    @Override
    public ApiResult searBreedListByItem(BreedDTO breedDTO) {
        ModelMap result = new ModelMap();
        try {
            List<BreedEntity> breedEntities = breedRepository.searBreedListByItem(breedDTO.getIndex());
            int count = breedRepository.getCount();
            result.addAttribute("count", count);
            result.addAttribute("page", breedDTO.getIndex());
            result.addAttribute("breedInfoList", breedEntities);
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }

    @Override
    public ApiResult searchBreedById(String id) {
        try {
            ModelMap result = new ModelMap();
            BreedEntity breedEntity = breedRepository.searchBreedById(id);
            if (breedEntity != null) {
                result.addAttribute("breedInfo", breedEntity);
            }
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorApiResult("网络异常，请稍后重试！");
        }
    }

    @Override
    public ApiResult addBreed(BreedDTO breedDTO, UserInfo userInfo) {
        try {
            ModelMap result = new ModelMap();
            if (breedDTO != null) {
                BreedEntity breedEntity = new BreedEntity();
                breedEntity.setBreedId(IdGen.uuid());
                breedEntity.setBreedNum(breedDTO.getBreedNum());
                breedEntity.setBreedHomeNum(breedDTO.getBreedHomeNum());
                breedEntity.setBreedType(breedDTO.getBreedType());
                breedEntity.setCreateBy(userInfo.getuRealName());
                breedEntity.setCreateOn(Calendar.getInstance());
                if (breedRepository.addBreed(breedEntity)) {
                    List<BreedEntity> breedEntities = breedRepository.searBreedList();
                    int count = breedRepository.getCount();
                    result.addAttribute("count", count);
                    result.addAttribute("breedInfoList", breedEntities);
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
    public ApiResult editBreed(BreedDTO breedDTO, UserInfo userInfo) {
        try {
            ModelMap result = new ModelMap();
            BreedEntity breedEntity = breedRepository.searchBreedById(breedDTO.getBreedId());
            if (breedEntity != null) {
                breedEntity.setBreedNum(breedDTO.getBreedNum());
                breedEntity.setBreedHomeNum(breedDTO.getBreedHomeNum());
                breedEntity.setBreedType(breedDTO.getBreedType());
                breedEntity.setModifyOn(Calendar.getInstance());
                breedEntity.setModifyBy(userInfo.getuRealName());
                if (breedRepository.editBreed(breedEntity)) {
                    List<BreedEntity> breedEntities = breedRepository.searBreedList();
                    result.addAttribute("breedInfoList", breedEntities);
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
    public ApiResult deleteBreed(String id) {
        try {
            ModelMap result = new ModelMap();
            BreedEntity breedEntity = breedRepository.searchBreedById(id);
            if (breedEntity != null) {
                if (breedRepository.deleteBreed(breedEntity)) {
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
