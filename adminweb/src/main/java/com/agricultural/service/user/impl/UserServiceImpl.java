package com.agricultural.service.user.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.FunctionMenu.repository.FunctionRepository;
import com.agricultural.domain.role.model.RoleFunction;
import com.agricultural.domain.role.model.RoleInfo;
import com.agricultural.domain.role.repository.RoleFunctionRepository;
import com.agricultural.domain.role.repository.RoleInfoRepository;
import com.agricultural.domain.user.dto.UserInfoDTO;
import com.agricultural.domain.user.dto.UserInfoListDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.domain.user.model.UserLoginInfo;
import com.agricultural.domain.user.model.UserRole;
import com.agricultural.domain.user.repository.UserLoginInfoRepository;
import com.agricultural.domain.user.repository.UserRepository;
import com.agricultural.domain.user.repository.UserRoleRepository;
import com.agricultural.service.function.inf.FunctionService;
import com.agricultural.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;
    @Autowired
    private RoleFunctionRepository roleFunctionRepository;
    @Autowired
    private FunctionRepository functionRepository;
    @Autowired
    private FunctionService functionService;

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
                UserRole userRole = userRoleRepository.searchUserRoleByUserId(userInfo.getuId());
                if (userRoleRepository.deleteUserRole(userRole)) {
                    modelMap.addAttribute("success", "删除成功");
                } else {
                    modelMap.addAttribute("error", "删除失败");
                }

            } else {
                modelMap.addAttribute("error", "删除失败");
            }
        } else {
            modelMap.addAttribute("error", "参数错误");
        }
        return new SuccessApiResult(modelMap);
    }

    @Override
    public UserInfo GetUserInfoByTokenValue(String tokenId) {
        String userId = userLoginInfoRepository.getUserIdBytokenId(tokenId);
        if (userId != null && !userId.equals("")) {
            UserInfo userInfo = userRepository.get(userId);
            return userInfo;
        }
        return null;
    }

    @Override
    public ApiResult updateUserPwd(UserInfoDTO userInfoDTO) {
        ModelMap result = new ModelMap();
        UserInfo userInfo = userRepository.get(userInfoDTO.getuId());
        if (userInfo != null) {
            if (!userInfo.getuPwd().equals(userInfoDTO.getuPwd())) {
                result.addAttribute("error", "请正确填写初始密码");
            } else {
                userInfo.setuPwd(userInfoDTO.getNewPwd());
                if (userRepository.editUser(userInfo)) {
                    result.addAttribute("success", "修改成功");
                } else {
                    result.addAttribute("error", "修改失败");
                }
            }
        } else {
            result.addAttribute("error", "没有找到对应的用户");
        }
        return new SuccessApiResult(result);
    }

    @Override
    public void logout(String tokenId, HttpServletRequest request, HttpServletResponse response) {
        List<UserLoginInfo> oldLoginInfo = userLoginInfoRepository.logout(tokenId);
        if (oldLoginInfo != null && oldLoginInfo.size() > 0) {
            for (UserLoginInfo userLoginInfo : oldLoginInfo) {
                userLoginInfo.setLoginType("2");
                userLoginInfoRepository.update(userLoginInfo);
                Cookie cookies[] = request.getCookies();
                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        if (cookies[i].getName().equals("vestaToken")) {
                            Cookie cookie = new Cookie("vestaToken", "");
                            cookie.setPath("/");
                            cookie.setDomain(request.getServerName());
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                            response.setHeader("P3P", "CP='CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR'");
                        }
                    }
                }

            }
        }
    }

    @Override
    public ApiResult GetInfoByTokenId(String userId) {
        ModelMap result = new ModelMap();
        if (userId != null) {
            UserInfo userInfo = userRepository.get(userId);
            if (userInfo.getuState() == 1) {
                UserInfoDTO userInfoDTO = new UserInfoDTO();
                userInfoDTO.setuId(userInfo.getuId());
                userInfoDTO.setuName(userInfo.getuName());
                userInfoDTO.setuHendImg(userInfo.getuHendImg());

                //获取一级菜单
                List<FunctionMenu> functionMenuList = functionService.searchFunctionListByUserId(userInfo.getuId());
                List<FunctionMenuDTO> functionMenuDTOList = new ArrayList<FunctionMenuDTO>();
                if (functionMenuList != null && functionMenuList.size() > 0) {
                    for (FunctionMenu mainMenu : functionMenuList) {
                        FunctionMenuDTO functionMenuDTO = new FunctionMenuDTO();
                        functionMenuDTO.setmId(mainMenu.getmId());
                        functionMenuDTO.setmName(mainMenu.getmName());
                        functionMenuDTO.setmUrl(mainMenu.getmUrl());

                        //获取二级菜单
                        List<FunctionMenu> twoLevelMenuList = functionService.searchTwoLevelMenuByUserId(userInfo.getuId(), mainMenu.getmId());

                        if (twoLevelMenuList != null && twoLevelMenuList.size() > 0) {
                            functionMenuDTO.setAllSubmenuList(twoLevelMenuList);
                        }
                        functionMenuDTOList.add(functionMenuDTO);
                    }
                }
                result.addAttribute("menuList", functionMenuDTOList);
                result.addAttribute("userInfo", userInfoDTO);

            } else {
                result.addAttribute("error", "用户已到期，请找管理员");
            }
        } else {
            result.addAttribute("error", "该用户还未登录");
        }
        return new SuccessApiResult(result);
    }
}
