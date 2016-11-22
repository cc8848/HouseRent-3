package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
        SysUsers sysUsers = (SysUsers) request.getSession().getAttribute("user");
        if (sysUsers == null) {
            return new ModelAndView("login");
        } else {
            return new ModelAndView("error").addObject("message", "用户尚未登录或登录超时，请重新登录！");
        }

    }

    @RequestMapping("/timeout")
    public String timeOut() {
        return "time_out";
    }

    @ResponseBody
    @RequestMapping("/register")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public JsonResult register(HttpServletRequest request) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");

        if (StringUtils.isEmpty(username))
            return JsonResult.error("用户名不能为空!");

        if (StringUtils.isEmpty(password))
            return JsonResult.error("密码不能为空!");

        if (null != iUserService.findSysUserByUserName(username))
            return JsonResult.error("用户名已存在!");

        //封装对象
        SysUsers sysUsers = new SysUsers();
        sysUsers.setUsername(username);
        sysUsers.setPassword(password);

        //将用户信息写入数据库
        int userID = iUserService.register(sysUsers);
        if (userID <= 0) {
            return JsonResult.error("用户注册失败!");
        } else {
            return JsonResult.success();
        }
    }

}
