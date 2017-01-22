package com.agricultural.service.feed.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.feed.dto.FeedDto;
import com.agricultural.domain.feed.model.FeedInfo;
import com.agricultural.domain.feed.repository.FeedRepository;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.service.feed.inf.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Calendar;
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

    @Override
    public ApiResult addFeed(FeedDto feedDto,UserInfo userInfos) {
        ModelMap modelMap = new ModelMap();
        try {
            if (feedDto != null) {
                FeedInfo feedInfo = new FeedInfo();
                feedInfo.setFeedId(IdGen.uuid());
                feedInfo.setFeedName(feedDto.getFeedName());
                feedInfo.setFeedType(feedDto.getType());
                feedInfo.setFeedDescribe(feedDto.getDescribe());
                feedInfo.setCreateOn(Calendar.getInstance());
                feedInfo.setCreateBy(userInfos.getuRealName());
                if (feedRepository.addFeed(feedInfo)) {
                    int count = feedRepository.getCount();
                    List<FeedInfo> feedInfoList = feedRepository.getFeedInfoList();
                    modelMap.addAttribute("count", count);
                    modelMap.addAttribute("feedInfoList", feedInfoList);
                    modelMap.addAttribute("success", "添加成功");
                } else {
                    modelMap.addAttribute("error", "添加失败");
                }
            }
            return new SuccessApiResult(modelMap);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("error", "网络异常，请稍后重试！");
            return new SuccessApiResult(modelMap);
        }
    }

    @Override
    public ApiResult searchFeedById(String id) {
        ModelMap result = new ModelMap();
        try {
            FeedInfo feedInfo = feedRepository.searchFeedById(id);
            result.addAttribute("feedInfo", feedInfo);
            return new SuccessApiResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            result.addAttribute("error", "网络异常，请稍后重试！");
            return new SuccessApiResult(result);
        }
    }

    @Override
    public ApiResult editFeed(FeedDto feedDto,UserInfo userInfos) {
        ModelMap result = new ModelMap();
        try {
            FeedInfo feedInfo = feedRepository.searchFeedById(feedDto.getFeedId());
            if (feedInfo != null) {
                feedInfo.setFeedName(feedDto.getFeedName());
                feedInfo.setFeedType(feedDto.getType());
                feedInfo.setFeedDescribe(feedDto.getDescribe());
                feedInfo.setModifyOn(Calendar.getInstance());
                feedInfo.setModifyBy(userInfos.getuRealName());
                if (feedRepository.editFeed(feedInfo)) {
                    List<FeedInfo> feedInfoList = feedRepository.getFeedInfoList();
                    result.addAttribute("feedInfoList", feedInfoList);
                    result.addAttribute("success", "编辑成功");
                } else {
                    result.addAttribute("error", "编辑失败");
                }
            } else {
                result.addAttribute("error", "没有找到对应的信息！");
            }
            return new SuccessApiResult(result);
        } catch (Exception e) {
            result.addAttribute("error", "网络异常，请稍后重试！");
            return new SuccessApiResult(result);
        }
    }

    @Override
    public ApiResult deleteFunction(String id) {
        ModelMap result = new ModelMap();
        try {
            FeedInfo feedInfo = feedRepository.searchFeedById(id);
            if (feedInfo != null) {
                if (feedRepository.deleteFeed(feedInfo)) {
                    result.addAttribute("success", "删除成功");
                } else {
                    result.addAttribute("error", "删除失败");
                }
            } else {
                result.addAttribute("error", "没有找到对应的信息！");
            }
            return new SuccessApiResult(result);
        } catch (Exception e) {
            result.addAttribute("error", "网络异常，请稍后重试！");
            return new SuccessApiResult(result);
        }
    }
}
