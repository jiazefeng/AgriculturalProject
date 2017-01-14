package com.agricultural.service.specfi.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.spcfi.dto.SpecfiDTO;
import com.agricultural.domain.spcfi.model.Specfi;
import com.agricultural.domain.spcfi.repository.SpecfiRepository;
import com.agricultural.service.specfi.inf.SpecfiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */
@Service
public class SpecfiServiceImpl implements SpecfiService{
    @Autowired
    private SpecfiRepository specfiRepository;

    @Override
    public ApiResult addSpecfi(SpecfiDTO specfiDTO) {
        ModelMap result = new ModelMap();
        if(specfiDTO!=null){
            Specfi specfi = new Specfi();
            specfi.setSpecfiTitle(specfiDTO.getSpecfiTitle());
            specfi.setSpecfiTime(specfiDTO.getSpecfiTime());
            specfi.setSpecifiLink(specfiDTO.getSpecifiLink());
            if(specfiRepository.addSpecfi(specfi)){
                result.addAttribute("success", "添加成功");
            }else {
                result.addAttribute("error", "添加失败");
            }
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult searchSpecfiInfoList() {
        List<Specfi> specfiList = specfiRepository.searchSpecfiList();
        List<SpecfiDTO> specfiDTOList = new ArrayList<SpecfiDTO>();
        if (specfiList != null && specfiList.size() > 0) {
            for (Specfi specfi :specfiList){
                SpecfiDTO specfiDTO = new SpecfiDTO();
                specfiDTO.setSpecfiTitle(specfi.getSpecfiTitle());
                specfiDTO.setSpecfiTime(specfi.getSpecfiTime());
                specfiDTO.setSpecifiLink(specfi.getSpecifiLink());
                specfiDTOList.add(specfiDTO);
            }
        }
        int count = specfiRepository.searchSpecfiCount();
        ModelMap result = new ModelMap();
        result.addAttribute("count", count);
        result.addAttribute("specfiList", specfiDTOList);
        return new SuccessApiResult(result);
    }
}
