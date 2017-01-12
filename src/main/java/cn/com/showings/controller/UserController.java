package cn.com.showings.controller;

import cn.com.showings.controller.base.BaseController;
import cn.com.showings.pojo.SysUsers;
import cn.com.showings.service.IUserService;
import cn.com.showings.pojo.JsonResult;
import cn.com.showings.tools.HttpTools;
import cn.com.showings.tools.MyStringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            return new ModelAndView("home/home");
        }
    }

    @ResponseBody
    @RequestMapping("/register")
    public JsonResult register(HttpServletRequest request) throws Exception {
        String username = MyStringTools.checkParameter(request.getParameter("username"), "手机号码不能为空！");
        String password = MyStringTools.checkParameter(request.getParameter("password"), "密码不能为空！");
        String name = MyStringTools.checkParameter(request.getParameter("name"), "真实姓名不能为空！");
        String captcha = MyStringTools.checkParameter(request.getParameter("captcha"), "手机验证码不能为空！");
        String license = MyStringTools.checkParameter(request.getParameter("license"), "身份证号码不能为空！");
        Integer sex = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("sex"), "性别不能为空！"));
        Integer job = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("job"), "工作类型不能为空！"));
        String companyAbbr = MyStringTools.checkParameter(request.getParameter("companyAbbr"), "公司简称不能为空！");
        Integer major = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("major"), "专业方向不能为空！"));

        //封装对象
        SysUsers sysUsers = new SysUsers();
        sysUsers.setUsername(username);
        sysUsers.setPassword(password);
        sysUsers.setName(name);
        sysUsers.setLicense(license);
        sysUsers.setMajor(major);
        sysUsers.setSex(sex == 1);
        sysUsers.setJob(job);
        sysUsers.setCompanyAbbr(companyAbbr);

        //将用户信息写入数据库
        if (iUserService.register(sysUsers)) {
            return JsonResult.success().setMessage("用户注册成功，请直接登录！");
        } else {
            return JsonResult.error("用户注册失败!");
        }
    }

    @ResponseBody
    @RequestMapping("/modify")
    public JsonResult modify(HttpServletRequest request) throws Exception {
        SysUsers sessionUser = HttpTools.getSessionUser(request);

        String name = MyStringTools.checkParameter(request.getParameter("name"), "真实姓名不能为空！");
        String license = MyStringTools.checkParameter(request.getParameter("license"), "身份证号码不能为空！");
        Integer sex = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("sex"), "性别不能为空！"));
        Integer job = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("job"), "工作类型不能为空！"));
        String companyAbbr = MyStringTools.checkParameter(request.getParameter("companyAbbr"), "公司简称不能为空！");
        Integer major = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("major"), "专业方向不能为空！"));

        //封装对象
        SysUsers sysUsers = new SysUsers();
        sysUsers.setUserId(sessionUser.getUserId());
        sysUsers.setName(name);
        sysUsers.setLicense(license);
        sysUsers.setMajor(major);
        sysUsers.setSex(sex == 1);
        sysUsers.setJob(job);
        sysUsers.setCompanyAbbr(companyAbbr);

        //将用户信息写入数据库
        if (iUserService.modify(sysUsers)) {
            SysUsers newUserInfo = iUserService.findUserByUserID(sessionUser.getUserId());
            request.getSession().setAttribute("user", newUserInfo);
            return JsonResult.success().setMessage("信息修改成功！");
        } else {
            return JsonResult.error("用户信息修改失败!");
        }
    }

    @ResponseBody
    @RequestMapping("/security/password")
    public JsonResult password(HttpServletRequest request) throws Exception {
        String old = MyStringTools.checkParameter(request.getParameter("old"), "原密码不能为空！");
        String newPwd = MyStringTools.checkParameter(request.getParameter("new"), "新密码不能为空！");
        String captcha = MyStringTools.checkParameter(request.getParameter("captcha"), "验证码不能为空！");

        SysUsers sysUsers = HttpTools.getSessionUser(request);

        if (iUserService.changePassword(newPwd, old, sysUsers)) {
            return JsonResult.success().setMessage("密码修改成功！");
        } else {
            return JsonResult.error("密码修改失败！");
        }
    }
}
