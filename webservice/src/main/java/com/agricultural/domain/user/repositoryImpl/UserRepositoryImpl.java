package com.agricultural.domain.user.repositoryImpl;

import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.domain.user.repository.UserRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxrocky on 2016/08/06.
 */
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<UserInfo> implements UserRepository {
    @Override
    public UserInfo login(UserInfo userInfo) {
        List<Criterion> sql = new ArrayList<Criterion>();
        sql.add(Restrictions.eq("uName", userInfo.getuName()));
        sql.add(Restrictions.eq("uPwd", userInfo.getuPwd()));
        return this.findUniqueResult(sql);
    }

    @Override
    public boolean addUser(UserInfo userInfo) {
        this.save(userInfo);
        return true;
    }

    @Override
    public boolean editUser(UserInfo userInfo) {
        this.update(userInfo);
        return true;
    }

    @Override
    public List<UserInfo> searchUserList(String userId) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from UserInfo as u where u.uState = ? and uId <> ?";
        params.add(1);
        params.add(userId);
        List<UserInfo> userInfoList = this.findByQueryList(hql,new PageInfoTools(),params);
        return userInfoList;
    }

    @Override
    public int searchUserCount() {
        List<Criterion> sql = new ArrayList<Criterion>();
        sql.add(Restrictions.eq("uState", 1));
        return this.findByCriteriaForPageCount(sql);
    }

    @Override
    public UserInfo searchUserInfoByUserId(String userId) {
        List<Object> params = new ArrayList<Object>();
        String hql ="from UserInfo as u where u.uId = ?";
        params.add(userId);
        return (UserInfo)this.findObjectByQueryResult(hql,params);
    }
}
