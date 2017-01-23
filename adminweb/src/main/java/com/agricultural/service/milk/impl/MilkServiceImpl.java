package com.agricultural.service.milk.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.milk.dto.MilkDTO;
import com.agricultural.domain.milk.model.MilkEntity;
import com.agricultural.domain.milk.repository.MilkRepository;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.milk.inf.MilkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Talent on 2017/1/23.
 */
@Service
public class MilkServiceImpl implements MilkService {
    @Autowired
    MilkRepository milkRepository;

    @Override
    public ApiResult getMilkInfoList() {
        ModelMap result = new ModelMap();
        try {
            int count = milkRepository.getCount();
            List<MilkEntity> milkEntities = milkRepository.getMilkInfoList();
            result.addAttribute("count", count);
            result.addAttribute("milkInfoList", milkEntities);
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网络异常，请稍后重试！");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult getMilkInfoList(MilkDTO milkDTO) {
        ModelMap result = new ModelMap();
        try {
            int count = milkRepository.getCount();
            List<MilkEntity> milkEntities = milkRepository.getMilkInfoList(milkDTO.getIndex());
            result.addAttribute("count", count);
            result.addAttribute("page", milkDTO.getIndex());
            result.addAttribute("milkInfoList", milkEntities);
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网络异常，请稍后重试！");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult getMilkInfoById(String id) {
        ModelMap result = new ModelMap();
        try {
            MilkEntity milkEntity = milkRepository.getMilkInfoById(id);
            if (milkEntity != null) {
                result.addAttribute("milkInfo", milkEntity);
            } else {
                result.addAttribute("error", "没有找到对应信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网络异常，请稍后重试！");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult addMilkInfo(MilkDTO milkDTO, UserInfo userInfos) {
        ModelMap result = new ModelMap();
        try {
            if (milkDTO != null) {
                MilkEntity milkEntity = new MilkEntity();
                milkEntity.setMilkId(IdGen.uuid());
                milkEntity.setIndividualRegistration(milkDTO.getIndividualRegistration());
                milkEntity.setGroupRegistration(milkDTO.getGroupRegistration());
                milkEntity.setModifyBy(userInfos.getuRealName());
                milkEntity.setCreateOn(Calendar.getInstance());
                if (milkRepository.addMilkInfo(milkEntity)) {
                    int count = milkRepository.getCount();
                    List<MilkEntity> milkEntities = milkRepository.getMilkInfoList();
                    result.addAttribute("count", count);
                    result.addAttribute("milkInfoList", milkEntities);
                    result.addAttribute("success", "添加成功");
                } else {
                    result.addAttribute("error", "添加失败");
                }
            } else {
                result.addAttribute("error", "参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网路异常，请稍后重试！");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult editMilkInfo(MilkDTO milkDTO, UserInfo userInfos) {
        ModelMap result = new ModelMap();
        try {
            if (milkDTO != null) {
                MilkEntity milkEntity = milkRepository.getMilkInfoById(milkDTO.getMilkId());
                if (milkEntity != null) {
                    milkEntity.setIndividualRegistration(milkDTO.getIndividualRegistration());
                    milkEntity.setGroupRegistration(milkDTO.getGroupRegistration());
                    milkEntity.setModifyBy(userInfos.getuRealName());
                    milkEntity.setModifyOn(Calendar.getInstance());
                    if (milkRepository.editMilkInfo(milkEntity)) {
                        List<MilkEntity> milkEntities = milkRepository.getMilkInfoList();
                        result.addAttribute("milkInfoList", milkEntities);
                        result.addAttribute("success", "编辑成功");
                    } else {
                        result.addAttribute("error", "编辑失败");
                    }
                } else {
                    result.addAttribute("error", "没有找到要修改的信息！");
                }
            } else {
                result.addAttribute("error", "参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网络异常。请稍后重试！");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult deleteMilkInfo(String id) {
        ModelMap result = new ModelMap();
        try {
            MilkEntity milkEntity = milkRepository.getMilkInfoById(id);
            if (milkEntity != null) {
                if (milkRepository.deleteMilkInfo(milkEntity)) {
                    result.addAttribute("success", "删除成功");
                } else {
                    result.addAttribute("error", "删除失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网络异常，请稍后重试！");
        }
        return new SuccessApiResult(result);
    }
}
