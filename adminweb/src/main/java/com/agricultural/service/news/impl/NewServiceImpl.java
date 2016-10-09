package com.agricultural.service.news.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.news.dto.NewDTO;
import com.agricultural.domain.news.model.News;
import com.agricultural.domain.news.repository.NewsRepository;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.news.inf.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.validation.constraints.AssertFalse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
@Service
public class NewServiceImpl implements NewService{
    @Autowired
    private NewsRepository newsRepository;
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
            if(newsRepository.addNews(news)){
                result.addAttribute("success", "添加成功");
            }else {
                result.addAttribute("error", "添加失败");
            }
        }
        return new SuccessApiResult(result);
    }
    @Override
    public ApiResult queryNewList(){
        List<News> newsList = newsRepository.searchNewList();
        List<NewDTO> newDTOList = new ArrayList<NewDTO>();
        if (newsList != null && newsList.size() > 0) {
            for (News news :newsList){
                NewDTO newDTO = new NewDTO();
                newDTO.setNewTitle(news.getNewTitle());
                newDTO.setNewTime(news.getNewTime());
                newDTO.setNewOther(news.getNewOther());
                newDTO.setNewContent(news.getNewContent());
                newDTOList.add(newDTO);
            }
        }
        int count = newsRepository.searchNewsCount();
        ModelMap result = new ModelMap();
        result.addAttribute("count", count);
        result.addAttribute("newsList", newsList);
        return new SuccessApiResult(result);
    }



}
