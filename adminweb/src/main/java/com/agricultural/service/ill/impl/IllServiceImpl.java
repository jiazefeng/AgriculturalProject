package com.agricultural.service.ill.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.ill.dto.IllDTO;
import com.agricultural.domain.ill.model.ComminIll;
import com.agricultural.domain.ill.repository.IllRepository;
import com.agricultural.domain.milk.model.MilkEntity;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.ill.inf.IllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/1/24 0024.
 */
@Service
public class IllServiceImpl implements IllService {
    @Autowired
    IllRepository illRepository;
    @Override
    public ApiResult getIllInfoList() {
        ModelMap result = new ModelMap();
        try {
            int count = illRepository.getCount();
            List<ComminIll> ill = illRepository.getIllInfoList();
            result.addAttribute("count", count);
            result.addAttribute("illInfoList", ill);
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网络异常，请稍后重试！");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult getIllInfoList(IllDTO illDTO) {
        ModelMap result = new ModelMap();
        try {
            int count = illRepository.getCount();
            List<ComminIll> ill = illRepository.getIllInfoList(illDTO.getIndex());
            result.addAttribute("count", count);
            result.addAttribute("page", illDTO.getIndex());
            result.addAttribute("milkInfoList", ill);
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网络异常，请稍后重试！");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult getIllInfoById(String id) {
        ModelMap result = new ModelMap();
        try {
            ComminIll ill = illRepository.getIllInfoById(id);
            if (ill != null) {
                result.addAttribute("illInfo", ill);
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
    public ApiResult addIllInfo(IllDTO illDTO, UserInfo userInfos) {
        ModelMap result = new ModelMap();
        try {
            if (illDTO != null) {
                ComminIll comminIll = new ComminIll();
                comminIll.setIllId(IdGen.uuid());
                comminIll.setIllName(illDTO.getIllName());
                comminIll.setIllYW(illDTO.getIllYW());
                comminIll.setIllZZ(illDTO.getIllZZ());
                if (illRepository.addIllInfo(comminIll)) {
                    int count = illRepository.getCount();
                    List<ComminIll> ill = illRepository.getIllInfoList();
                    result.addAttribute("count", count);
                    result.addAttribute("illInfoList", ill);
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
    public ApiResult editIllInfo(IllDTO illDTO, UserInfo userInfos) {
        ModelMap result = new ModelMap();
        try {
            if (illDTO != null) {
                ComminIll comminIll = illRepository.getIllInfoById(illDTO.getIllId());
                if (comminIll != null) {
                    comminIll.setIllName(illDTO.getIllName());
                    comminIll.setIllYW(illDTO.getIllYW());
                    comminIll.setIllZZ(illDTO.getIllZZ());
                    if (illRepository.editIllInfo(comminIll)) {
                        List<ComminIll> ill = illRepository.getIllInfoList();
                        result.addAttribute("illInfoList", ill);
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
    public ApiResult deleteIllInfo(String id) {
        ModelMap result = new ModelMap();
        try {
            ComminIll ill = illRepository.getIllInfoById(id);
            if (ill != null) {
                if (illRepository.deleteIllInfo(ill)) {
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
