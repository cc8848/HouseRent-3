package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.LoginTimeOutException;
import com.magic.rent.pojo.*;
import com.magic.rent.service.*;
import com.magic.rent.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
    private ISysMenuService iSysMenuService;

    @Autowired
    private ICompanyService iCompanyService;

    @Autowired
    private IStoreService iStoreService;

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request) throws Exception {
        //此数据在登录成功时存入Session。详情在LoginAuthenticationController中可查找
        SysUsers sessionUsers = (SysUsers) request.getSession().getAttribute("user");

        if (null == sessionUsers || null == sessionUsers.getUserId()) {
            throw new LoginTimeOutException(messageSourceAccessor.getMessage("LoginService.LoginTimeOut", "用户尚未登录或登录失效，请重新登录！"));
        }
        Map<String, Object> model = new HashMap<String, Object>();

        List<SysMenu> sysMenuList = iSysMenuService.selectSysMenusByUserID(sessionUsers.getUserId());
        model.put("sysMenuList", sysMenuList);
        LogUtil.LogPOJO(logger, sysMenuList);

        boolean haveCompany = false;
        boolean haveStore = false;
        boolean isSeller = false;

        //查询公司信息
        Company company = iCompanyService.getCurrentCompanyInfo(sessionUsers.getUserId());
        if (null != company) {
            haveCompany = true;
            model.put("haveCompany", haveCompany);
            model.put("company", company);
        } else {
            model.put("haveCompany", haveCompany);
        }
        //查询门店信息
        Store store = iStoreService.getCurrentStoreInfo(sessionUsers.getUserId());
        if (null != store) {
            haveStore = true;
            model.put("haveStore", haveStore);
            model.put("store", store);
        } else {
            model.put("haveStore", haveStore);
        }
        Store storeForSeller = iUserSellerService.myStore(sessionUsers.getUserId());
        if (null != storeForSeller) {
            isSeller = true;
            model.put("isSeller", isSeller);
            model.put("storeForSeller", storeForSeller);
        } else {
            model.put("isSeller", isSeller);
        }
        //查询销售员所门店信息
        return new ModelAndView("home", model);
    }
}
