package com.agricultural.service.feed.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.domain.feed.model.FeedInfo;
import com.agricultural.domain.feed.repository.FeedRepository;
import com.agricultural.service.feed.inf.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by Talent on 2016/12/29.
 */
@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    FeedRepository feedRepository;

    @Override
    public ApiResult getFeedInfoList() {
        int count = feedRepository.getCount();
        List<FeedInfo> feedInfoList = feedRepository.getFeedInfoList();
        ModelMap result = new ModelMap();
        result.addAttribute("count", count);
        result.addAttribute("feedInfoList", feedInfoList);
        return new SuccessApiResult(result);
    }
}
