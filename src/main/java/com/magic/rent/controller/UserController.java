package com.magic.rent.controller;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/timeout")
    public String timeOut() {
        return "timeOut";
    }

    @ResponseBody
    @RequestMapping("/register")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public JsonResult register(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        if (userID <= 0)
            return JsonResult.error("用户注册失败!");

        return JsonResult.success("注册成功,请登录!", null);
    }

    @ResponseBody
    @RequestMapping("/getUserInfo")
    public JsonResult getUserInfo(HttpServletRequest request) throws Exception {
        return (JsonResult) request.getSession().getAttribute("userInfo");
    }


}
