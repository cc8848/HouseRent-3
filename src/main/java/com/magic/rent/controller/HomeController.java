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

    private final static int auditing = 1;

    private final static int refuse = 2;

    private final static int success = 3;

    @Autowired
    private ISellerService iSellerService;

    @RequestMapping("/sellerHome")
    public ModelAndView sellerHome(HttpServletRequest request) {
        //此数据在登录成功时存入Session。详情在LoginAuthenticationController中可查找
        SysUsers sysUsers = (SysUsers) request.getSession().getAttribute("user");
        if (null == sysUsers || null == sysUsers.getUserId()) {
            throw new ParameterException(messageSourceAccessor.getMessage("HomeService.SysUser", "用户尚未登录或登录失效，请重新登录！"));
        }
        UserSeller userSeller = iSellerService.selectSellerInfoByUserID(sysUsers);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", sysUsers);
        if (null == userSeller) {
            //如果查询为空，则尚未挂到任何中介机构当中,跳转到机构申请页面
            return new ModelAndView("", model);
        } else {
            switch (userSeller.getUserStatus().getId()) {
                case auditing:
                case refuse:
                    //当状态为审核中或拒绝的，返回审核状态页面
                    model.put("userSeller", userSeller);
                    return new ModelAndView("auditing", model);
                case success:
                    model.put("userSeller", userSeller);
                    return new ModelAndView("seller_home", model);
                default:
                    model.put("userSeller", userSeller);
                    return new ModelAndView("auditing", model);
            }
        }
    }
}
