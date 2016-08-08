package com.agricultural.domain.user.repositoryImpl;

import com.agricultural.domain.user.model.UserLoginInfo;
import com.agricultural.domain.user.repository.UserLoginInfoRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxrocky on 2016/08/08.
 */
@Repository
public class UserLoginInfoRepositoryImpl extends BaseRepositoryImpl<UserLoginInfo> implements UserLoginInfoRepository {
    @Override
    public boolean addUserLoginInfo(UserLoginInfo userLoginInfo) {
        this.save(userLoginInfo);
        return true;
    }

    @Override
    public String getUserIdBytokenId(String tokenId) {
        List<Object> params = new ArrayList<Object>();
        String sql = "from UserLoginInfo where tokenId = ? and loginType = ?";
        params.add(tokenId);
        params.add("1");
        UserLoginInfo userLoginInfo= (UserLoginInfo)this.findObjectByQueryResult(sql,params);
        return userLoginInfo.getUserId();
    }

    @Override
    public List<UserLoginInfo> logout(String tokenId) {
        String sql = "from UserLoginInfo where tokenId = ? and loginType = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(tokenId);
        params.add("1");
        return this.findByQueryList(sql, params);
    }
}
