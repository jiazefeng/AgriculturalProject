package com.agricultural.domain.user.repositoryImpl;

import com.agricultural.domain.user.model.UserRole;
import com.agricultural.domain.user.repository.UserRoleRepository;
import com.agricultural.hibernate.BaseRepository;
import com.agricultural.hibernate.BaseRepositoryImpl;
import com.agricultural.page.PageInfoTools;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxrocky on 2016/08/06.
 */
@Repository
public class UserRoleRepositoryImpl extends BaseRepositoryImpl<UserRole> implements UserRoleRepository {
    @Override
    public boolean addUserRole(UserRole userRole) {
       this.save(userRole);
        return true;
    }

    @Override
    public boolean deleteUserRole(UserRole userRole) {
        this.deletePhysical(userRole);
        return true;
    }

    @Override
    public List<UserRole> searchUserRoleListByUserId(String userId) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from UserRole as u where u.userId = ?";
        params.add(userId);
        List<UserRole> userRoleList = this.findByQueryList(hql,params);
        return userRoleList;
    }

    @Override
    public UserRole searchUserRoleByUserId(String userId) {
        List<Object> params = new ArrayList<Object>();
        String hql = "from UserRole as u where u.userId = ?";
        params.add(userId);
        UserRole userRole = (UserRole)this.findObjectByQueryResult(hql,params);
        return userRole;
    }

    @Override
    public boolean editUserRole(UserRole userRole) {
        this.update(userRole);
        return true;
    }
}
