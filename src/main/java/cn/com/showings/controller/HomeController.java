package cn.com.showings.controller;

import cn.com.showings.controller.base.BaseController;
import cn.com.showings.pojo.exception.LoginTimeOutException;
import cn.com.showings.pojo.SysUsers;
import cn.com.showings.tools.FileTools;
import cn.com.showings.tools.HttpTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 16/10/6
 * 类说明:家访问控制器
 * 更新记录：
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {


    @RequestMapping
    public String home(HttpServletRequest request) throws Exception {
        //此数据在登录成功时存入Session。详情在LoginAuthenticationController中可查找
        SysUsers sessionUsers = (SysUsers) request.getSession().getAttribute("user");

        if (null == sessionUsers || null == sessionUsers.getUserId()) {
            throw new LoginTimeOutException(messageSourceAccessor.getMessage("LoginService.LoginTimeOut", "用户尚未登录或登录失效，请重新登录！"));
        }
        return "home/home";
    }

    @RequestMapping("/account")
    public ModelAndView account(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView("home/account");
        //获取用户ID用于指向对应文件夹
        SysUsers sysUsers = HttpTools.getSessionUser(request);
        modelAndView.addObject("user", sysUsers);

        //获取头像路径
        int userID = sysUsers.getUserId();
        String filePath = FileTools.getPortraitPath(userID);
        List<File> fileList = FileTools.getListFiles(filePath);
        if (null == fileList || fileList.size() == 0) {
            String defaultSrc = "/img/default_portrait.jpg";
            modelAndView.addObject("portrait_src", defaultSrc);
        } else {
            String src = FileTools.filePathToSRC(fileList.get(0).toString(), FileTools.IMG);
            modelAndView.addObject("portrait_src", src);
        }

        return modelAndView;
    }

    @RequestMapping("/account_security")
    public String accountUpdate() throws Exception {
        return "home/account_security";
    }

    @RequestMapping("/hand_house_issue")
    public String handHouseIssue() throws Exception{
        return "home/hand_house_issue";
    }
}
