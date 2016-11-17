package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/6
 * 类说明:
 */
@Controller
@RequestMapping("/user")
public class HomeController extends BaseController {

    @Autowired
    private ISellerService iSellerService;

    @RequestMapping("/sellerHome")
    public ModelAndView sellerHome(HttpServletRequest request) {
        //此数据在登录成功时存入Session。详情在LoginAuthenticationController中可查找
        SysUsers sysUsers = (SysUsers) request.getSession().getAttribute("user");
        if (null == sysUsers || null == sysUsers.getUserId()) {
            throw new ParameterException(messageSourceAccessor.getMessage("HomeService.SysUser", "用户尚未登录或登录失效，请重新登录！"));
        }
        Map<String, Object> model = new HashMap<String, Object>();

        UserSeller userSeller = iSellerService.selectSellerInfoByUserID(sysUsers);

        if (null != userSeller) {
            model.put("userSeller", userSeller);
            model.put("user", sysUsers);
            return new ModelAndView("seller_home", model);
        } else {
            return new ModelAndView("seller_home", model);
        }
    }


}
