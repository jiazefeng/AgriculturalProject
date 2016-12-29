package com.agricultural.service.basic.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.domain.news.dto.NewDTO;
import com.agricultural.domain.news.model.News;
import com.agricultural.domain.news.repository.NewsRepository;
import com.agricultural.service.basic.BaiscService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
public class BasicServiceImpl<T> implements BaiscService<T> {
    @Autowired
    private NewsRepository newsRepository;

    /**
     * 基本查询方法
     * @return ApiResult
     */
   public ApiResult basicSreach(){
//        //List<T> list = newsRepository.searchNewList();//FIXME 对DAO层做封装basicDAO
//        List<T> list = new ArrayList<T>();//
//        if (list != null && list.size() > 0) {
//            for (T item :list){
//                //FIXME 对entity层做封装basicDTO()
////                for (News news :newsList){
////                    NewDTO newDTO = new NewDTO();
////                    newDTO.setNewTitle(news.getNewTitle());
////                    newDTO.setNewTime(news.getNewTime());
////                    newDTO.setNewOther(news.getNewOther());
////                    newDTO.setNewContent(news.getNewContent());
////                    newDTO.setNewIntro(news.getNewIntro());
////                    newDTO.setNewLink(news.);
////
////                    newDTOList.add(newDTO);
////                }
//            }
//        }
       return null;
  }

}
