package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IUserService;
import com.magic.rent.pojo.JsonResult;
import com.magic.rent.util.FileUtil;
import com.magic.rent.util.HttpUtil;
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
import java.io.File;
import java.util.List;

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
        String captcha = MyStringUtil.checkParameter(request.getParameter("captcha"), "手机验证码不能为空！");
        String license = MyStringUtil.checkParameter(request.getParameter("license"), "身份证号码不能为空！");
        Integer sex = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("sex"), "性别不能为空！"));
        Integer job = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("job"), "工作类型不能为空！"));
        String companyAbbr = MyStringUtil.checkParameter(request.getParameter("companyAbbr"), "公司简称不能为空！");
        Integer major = Integer.parseInt(MyStringUtil.checkParameter(request.getParameter("major"), "专业方向不能为空！"));

        //封装对象
        SysUsers sysUsers = new SysUsers();
        sysUsers.setUsername(username);
        sysUsers.setPassword(password);
        sysUsers.setName(name);
        sysUsers.setLicense(license);
        sysUsers.setMajor(major);
        if (sex == 1) {
            sysUsers.setSex(true);//1是男，2是女
        } else if (sex == 2) {
            sysUsers.setSex(false);
        } else {
            throw new BusinessException("请选择正确的性别！");
        }
        sysUsers.setJob(job);
        sysUsers.setCompanyAbbr(companyAbbr);

        //将用户信息写入数据库
        if (iUserService.register(sysUsers)) {
            return JsonResult.success().setMessage("用户注册成功，请直接登录！");
        } else {
            return JsonResult.error("用户注册失败!");
        }
    }

}
