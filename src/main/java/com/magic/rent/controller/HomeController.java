package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.LoginTimeOutException;
import com.magic.rent.pojo.SysMenu;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.ISysMenuService;
import com.magic.rent.util.FileUtil;
import com.magic.rent.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
@RequestMapping("/home")
public class HomeController extends BaseController {

    @Autowired
    private ISysMenuService iSysMenuService;

    @RequestMapping
    public ModelAndView home(HttpServletRequest request) throws Exception {
        //此数据在登录成功时存入Session。详情在LoginAuthenticationController中可查找
        SysUsers sessionUsers = (SysUsers) request.getSession().getAttribute("user");

        if (null == sessionUsers || null == sessionUsers.getUserId()) {
            throw new LoginTimeOutException(messageSourceAccessor.getMessage("LoginService.LoginTimeOut", "用户尚未登录或登录失效，请重新登录！"));
        }
        Map<String, Object> model = new HashMap<String, Object>();

        List<SysMenu> sysMenuList = iSysMenuService.selectSysMenusByUserID(sessionUsers.getUserId());
        model.put("sysMenuList", sysMenuList);

        //查询销售员所门店信息
        return new ModelAndView("home/home", model);
    }

    @RequestMapping("/account")
    public ModelAndView account(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView("home/account");
        //获取用户ID用于指向对应文件夹
        SysUsers sysUsers = HttpUtil.getSessionUser(request);
        modelAndView.addObject("user", sysUsers);

        //获取头像路径
        int userID = sysUsers.getUserId();
        String filePath = FileUtil.getPortraitPath(userID);
        List<File> fileList = FileUtil.getListFiles(filePath);
        if (null == fileList || fileList.size() == 0) {
            String defaultSrc = "/img/default.jpg";
            modelAndView.addObject("portrait_src", defaultSrc);
        } else {
            String src = FileUtil.filePathToSRC(fileList.get(0).toString(), FileUtil.IMG);
            modelAndView.addObject("portrait_src", src);
        }
        return modelAndView;
    }

    @RequestMapping("/account_update")
    public ModelAndView accountUpdate(HttpServletRequest request) throws Exception {

        return new ModelAndView("home/account_update");
    }

    @RequestMapping("/portrait/modify")
    public ModelAndView portraitModify(HttpServletRequest request) throws Exception {


        return null;
    }
}
