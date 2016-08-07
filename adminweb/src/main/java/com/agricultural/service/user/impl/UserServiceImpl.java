package com.agricultural.service.user.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.role.model.RoleInfo;
import com.agricultural.domain.role.repository.RoleInfoRepository;
import com.agricultural.domain.user.dto.UserInfoDTO;
import com.agricultural.domain.user.dto.UserInfoListDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.domain.user.model.UserRole;
import com.agricultural.domain.user.repository.UserRepository;
import com.agricultural.domain.user.repository.UserRoleRepository;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxrocky on 2016/08/06.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleInfoRepository roleInfoRepository;

    @Override
    public ApiResult addUser(UserInfoDTO userInfoDTO) {
        ModelMap result = new ModelMap();
        if (userInfoDTO != null) {
            UserInfo userInfo = new UserInfo();
            userInfo.setuId(IdGen.uuid());
            userInfo.setuName(userInfoDTO.getuName());
            userInfo.setuRealName(userInfoDTO.getuRealName());
            userInfo.setPhone(userInfoDTO.getPhone());
            userInfo.setuPwd(userInfoDTO.getuPwd());
            userInfo.setuState(1);
            userInfo.setPersonalProfile(userInfoDTO.getPersonalProfile());
            userInfo.setuHendImg(userInfoDTO.getuHendImg());
            if (userRepository.addUser(userInfo)) {
                UserRole userRole = new UserRole();
                userRole.setUrId(IdGen.uuid());
                userRole.setRoleId(userInfoDTO.getUroleId());
                userRole.setUserId(userInfo.getuId());
                if (userRoleRepository.addUserRole(userRole)) {
                    result.addAttribute("success", "添加成功");
                } else {
                    result.addAttribute("error", "添加失败");
                }
            } else {
                result.addAttribute("error", "添加失败");
            }
        }
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult queryUserList() {
        List<UserInfo> userInfoList = userRepository.searchUserList();
        List<UserInfoListDTO> userInfoListDTOList = new ArrayList<UserInfoListDTO>();
        if (userInfoList != null && userInfoList.size() > 0) {
            for (UserInfo userInfo : userInfoList) {
                UserInfoListDTO userInfoListDTO = new UserInfoListDTO();
                userInfoListDTO.setuId(userInfo.getuId());
                userInfoListDTO.setuName(userInfo.getuName());
                userInfoListDTO.setuRealName(userInfo.getuRealName());
                userInfoListDTO.setPhone(userInfo.getPhone());
                userInfoListDTO.setPersonalProfile(userInfo.getPersonalProfile());

                List<UserRole> userRoleList = userRoleRepository.searchUserRoleListByUserId(userInfo.getuId());
                if (userRoleList != null && userRoleList.size() > 0) {
                    for (UserRole userRole : userRoleList) {
                        RoleInfo roleInfo = roleInfoRepository.get(userRole.getRoleId());
                        userInfoListDTO.setRoleName(roleInfo.getrName());
                    }
                }
                userInfoListDTOList.add(userInfoListDTO);
            }
        }
        int count = userRepository.searchUserCount();
        ModelMap result = new ModelMap();
        result.addAttribute("count", count);
        result.addAttribute("userInfoList", userInfoListDTOList);
        return new SuccessApiResult(result);
    }

    @Override
    public ApiResult searchUserInfoById(String userId) {
        ModelMap modelMap = new ModelMap();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        if (userId != null) {
            UserInfo userInfo = userRepository.searchUserInfoByUserId(userId);
            if (userInfo != null) {
                userInfoDTO.setuName(userInfo.getuName());
                userInfoDTO.setuRealName(userInfo.getuRealName());
                userInfoDTO.setPhone(userInfo.getPhone());
                userInfoDTO.setPersonalProfile(userInfo.getPersonalProfile());
                userInfoDTO.setuHendImg(userInfo.getuHendImg());
                List<UserRole> userRoleList = userRoleRepository.searchUserRoleListByUserId(userInfo.getuId());
                if (userRoleList != null && userRoleList.size() > 0) {
                    for (UserRole userRole : userRoleList) {
                        userInfoDTO.setUroleId(userRole.getRoleId());

                    }
                }
            }
        }
        List<RoleInfo> roleInfoList = roleInfoRepository.searchRoleInfo();
        modelMap.addAttribute("userInfo", userInfoDTO);
        modelMap.addAttribute("roleInfoList", roleInfoList);
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult editUserInfo(UserInfoDTO userInfoDTO) {
        ModelMap modelMap = new ModelMap();
        if (userInfoDTO != null) {
            UserInfo userInfo = userRepository.searchUserInfoByUserId(userInfoDTO.getuId());
            userInfo.setuName(userInfoDTO.getuName());
            userInfo.setuRealName(userInfoDTO.getuRealName());
            userInfo.setuHendImg(userInfoDTO.getuHendImg());
            userInfo.setPersonalProfile(userInfoDTO.getPersonalProfile());
            userInfo.setPhone(userInfoDTO.getPhone());
            if (userRepository.editUser(userInfo)) {
                UserRole userRole = userRoleRepository.searchUserRoleByUserId(userInfoDTO.getuId());
                userRole.setRoleId(userInfoDTO.getUroleId());
                if (userRoleRepository.editUserRole(userRole)) {
                    modelMap.addAttribute("success", "修改成功");
                } else {
                    modelMap.addAttribute("error", "修改失败");
                }
            }
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult deleteUserInfo(String id) {
        ModelMap modelMap = new ModelMap();
        if (id != null) {
            UserInfo userInfo = userRepository.searchUserInfoByUserId(id);
            userInfo.setuState(0);
            if (userRepository.editUser(userInfo)) {
                modelMap.addAttribute("success", "删除成功");
            } else {
                modelMap.addAttribute("error", "删除失败");
            }
        } else {
            modelMap.addAttribute("error", "参数错误");
        }
        return new SuccessApiResult(modelMap);
    }
}
