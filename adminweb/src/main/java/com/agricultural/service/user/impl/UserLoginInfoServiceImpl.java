package com.agricultural.service.user.impl;

import com.agricultural.domain.user.repository.UserLoginInfoRepository;
import com.agricultural.service.user.inf.UserLoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiazefeng on 2016/08/08.
 */
@Service
public class UserLoginInfoServiceImpl implements UserLoginInfoService {
    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;
    @Override
    public String getUserIdBytokenId(String tokenId) {
        return userLoginInfoRepository.getUserIdBytokenId(tokenId);
    }
}
