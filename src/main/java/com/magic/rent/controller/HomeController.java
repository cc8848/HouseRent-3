package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.LoginTimeOutException;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.IUserSellerService;
import com.magic.rent.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 16/10/6
 * 类说明:家访问控制器
 * 更新记录：
 */
@Controller
@RequestMapping("/user")
public class HomeController extends BaseController {

    @Autowired
    private IUserSellerService iUserSellerService;

    @Autowired
    private IUserService iUserService;

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request) throws Exception {
        //此数据在登录成功时存入Session。详情在LoginAuthenticationController中可查找
        SysUsers SessionUsers = (SysUsers) request.getSession().getAttribute("user");

        if (null == SessionUsers || null == SessionUsers.getUserId()) {
            throw new LoginTimeOutException(messageSourceAccessor.getMessage("LoginService.LoginTimeOut", "用户尚未登录或登录失效，请重新登录！"));
        }


        Map<String, Object> model = new HashMap<String, Object>();
        UserSeller userSeller = iUserSellerService.selectSellerInfoByUserID(SessionUsers.getUserId());
        if (null != userSeller) {
            logger.info(userSeller.toString());
        }
        
        model.put("seller", userSeller);
        return new ModelAndView("home", model);
    }
}
