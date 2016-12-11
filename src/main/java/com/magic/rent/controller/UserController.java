package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.pojo.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
            return new ModelAndView("views/login");
        } else {
            return new ModelAndView("views/error").addObject("message", "用户尚未登录或登录超时，请重新登录！");
        }
    }

    @ResponseBody
    @RequestMapping("/register")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public JsonResult register(HttpServletRequest request) throws Exception {
        String username = MyStringUtil.checkParameter(request.getParameter("username"), "手机号码不能为空！");
        String password = MyStringUtil.checkParameter(request.getParameter("password"), "密码不能为空！");
        String name = MyStringUtil.checkParameter(request.getParameter("name"), "真实姓名不能为空！");
        String captcha = request.getParameter("captcha");

        if (StringUtils.isEmpty(username))
            return JsonResult.error("用户名不能为空!");

        if (StringUtils.isEmpty(password))
            return JsonResult.error("密码不能为空!");

        //封装对象
        SysUsers sysUsers = new SysUsers();
        sysUsers.setUsername(username);
        sysUsers.setPassword(password);
        sysUsers.setName(name);

        //将用户信息写入数据库
        if (iUserService.register(sysUsers)) {
            return JsonResult.success().setMessage("用户注册成功，请直接登录！");
        } else {
            return JsonResult.error("用户注册失败!");
        }
    }

}
