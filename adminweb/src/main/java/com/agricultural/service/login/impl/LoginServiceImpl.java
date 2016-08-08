package com.agricultural.service.login.impl;

import com.agricultural.common.result.ApiResult;
import com.agricultural.common.result.SuccessApiResult;
import com.agricultural.common.util.IdGen;
import com.agricultural.domain.FunctionMenu.dto.FunctionMenuDTO;
import com.agricultural.domain.FunctionMenu.model.FunctionMenu;
import com.agricultural.domain.FunctionMenu.repository.FunctionRepository;
import com.agricultural.domain.role.model.RoleFunction;
import com.agricultural.domain.role.repository.RoleFunctionRepository;
import com.agricultural.domain.user.dto.LoginDto;
import com.agricultural.domain.user.dto.UserInfoDTO;
import com.agricultural.domain.user.model.UserInfo;
import com.agricultural.domain.user.model.UserLoginInfo;
import com.agricultural.domain.user.model.UserRole;
import com.agricultural.domain.user.repository.UserLoginInfoRepository;
import com.agricultural.domain.user.repository.UserRepository;
import com.agricultural.domain.user.repository.UserRoleRepository;
import com.agricultural.service.function.inf.FunctionService;
import com.agricultural.service.login.inf.LoginService;
import com.agricultural.service.role.impl.RoleInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by maxrocky on 2016/08/08.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;
    @Autowired
    private RoleFunctionRepository roleFunctionRepository;
    @Autowired
    private FunctionRepository functionRepository;
    @Autowired
    private FunctionService functionService;

    @Override
    public ApiResult login(LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) {
        ModelMap result = new ModelMap();
        if (loginDto != null) {
            HttpSession session = request.getSession();
            UserInfo userInfo = new UserInfo();
            userInfo.setuName(loginDto.getUserName());
            userInfo.setuPwd(loginDto.getPwd());

            UserInfo userInfo1 = userRepository.login(userInfo);
            if (userInfo1 != null) {
                if (userInfo1.getuState() == 1) {
                    UserInfoDTO userInfoDTO = new UserInfoDTO();
                    userInfoDTO.setuId(userInfo1.getuId());
                    userInfoDTO.setuName(userInfo1.getuName());
                    userInfoDTO.setuHendImg(userInfo1.getuHendImg());

                    UserLoginInfo userLoginInfo = new UserLoginInfo();
                    userLoginInfo.setTokenId(IdGen.uuid());
                    userLoginInfo.setLoginType("1");
                    userLoginInfo.setMakeDate(new Date());
                    userLoginInfo.setUserId(userInfo1.getuId());

                    if (userLoginInfoRepository.addUserLoginInfo(userLoginInfo)) {
                        Cookie cookie = new Cookie("vestaToken", userLoginInfo.getTokenId());
                        cookie.setPath("/");
                        cookie.setDomain(request.getServerName());
                        cookie.setMaxAge(3600 * 24 * 30);
                        response.addCookie(cookie);
                        response.setHeader("P3P", "CP='CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR'");
                        //获取一级菜单
                        List<FunctionMenu> functionMenuList = functionService.searchFunctionListByUserId(userInfo1.getuId());
                        List<FunctionMenuDTO> functionMenuDTOList = new ArrayList<FunctionMenuDTO>();
                        if (functionMenuList != null && functionMenuList.size() > 0) {
                            for (FunctionMenu mainMenu : functionMenuList) {
                                FunctionMenuDTO functionMenuDTO = new FunctionMenuDTO();
                                functionMenuDTO.setmId(mainMenu.getmId());
                                functionMenuDTO.setmName(mainMenu.getmName());
                                functionMenuDTO.setmUrl(mainMenu.getmUrl());

                                //获取二级菜单
                                List<FunctionMenu> twoLevelMenuList = functionService.searchTwoLevelMenuByUserId(userInfo1.getuId(), mainMenu.getmId());

                                if (twoLevelMenuList != null && twoLevelMenuList.size() > 0) {
                                    functionMenuDTO.setAllSubmenuList(twoLevelMenuList);
                                }
                                functionMenuDTOList.add(functionMenuDTO);
                            }
                        }
                        result.addAttribute("success", "登录成功");
                        result.addAttribute("menuList", functionMenuDTOList);
                        result.addAttribute("userInfo", userInfoDTO);
                        result.addAttribute("token", userLoginInfo.getTokenId());
                    } else {
                        result.addAttribute("error", "登录失败");
                    }

                } else {
                    result.addAttribute("error", "用户已到期，请找管理员");
                }
            } else {
                result.addAttribute("error", "用户名或密码错误");
            }
        } else {
            result.addAttribute("error", "用户名和密码不能为空！");
        }
        return new SuccessApiResult(result);
    }
}
