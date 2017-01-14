package com.agricultural.service.news.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.DateUtils;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.farm.model.RanchingInfo;
import com.agricultural.domain.news.dto.NewDTO;
import com.agricultural.domain.news.model.News;
import com.agricultural.domain.news.repository.NewsRepository;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.news.inf.NewService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.validation.constraints.AssertFalse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18 0018.
 *
 */
@Service
public class NewServiceImpl implements NewService{
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public ApiResult searchNewsInfoList(){
        List<News> newsList = newsRepository.searchNewList();
        List<NewDTO> newDTOList = new ArrayList<NewDTO>();
        if (newsList != null && newsList.size() > 0) {
            for (News news :newsList){
                NewDTO newDTO = new NewDTO();
                newDTO.setNewTitle(news.getNewTitle());
                newDTO.setNewTime(news.getNewTime());
                newDTO.setNewOther(news.getNewOther());
                newDTO.setNewContent(news.getNewContent());
                newDTO.setNewIntro(news.getNewIntro());
                newDTO.setNewLink(news.getOtherNew());
                newDTOList.add(newDTO);
            }
        }
        int count = newsRepository.searchNewsCount();
        ModelMap result = new ModelMap();
        result.addAttribute("count", count);
        result.addAttribute("newsList", newDTOList);
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult editNew(NewDTO newDTO) {
        ModelMap modelMap = new ModelMap();
        if (newDTO != null) {
            News news = newsRepository.searchNewsByNewsId(newDTO.getId());
            if (news != null) {
                news.setNewTitle(newDTO.getNewTitle());
                news.setNewIntro(newDTO.getNewIntro());
                news.setNewOther(newDTO.getNewOther());
                news.setNewIntro(newDTO.getNewIntro());
                news.setOtherNew(newDTO.getNewLink());

                if (newsRepository.editNew(news)) {
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
    public ApiResult addNew(NewDTO newDTO) {
        ModelMap result = new ModelMap();
        if(newDTO!=null){
            News news = new News();
            news.setNewId(IdGen.uuid());
            news.setNewTitle(newDTO.getNewTitle());
            news.setNewTime(newDTO.getNewTime());
            news.setNewOther(newDTO.getNewOther());
            news.setNewContent(newDTO.getNewContent());
            news.setNewIntro(newDTO.getNewIntro());
            news.setOtherNew(newDTO.getNewLink());
            if(newsRepository.addNews(news)){
                result.addAttribute("success", "添加成功");
            }else {
                result.addAttribute("error", "添加失败");
            }
        }
        return new SuccessApiResult(result);
    }



}
