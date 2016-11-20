package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.LoginTimeOutException;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.pojo.UserSeller;
import com.magic.rent.pojo.UserStatus;
import com.magic.rent.service.IUserSellerService;
import com.magic.rent.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 16/10/6
 * 类说明:销售员控制器
 */
@Controller
@RequestMapping("/auditing")
public class UserSellerController extends BaseController {

    @Autowired
    private IUserSellerService iUserSellerService;


    @ResponseBody
    @RequestMapping("/submit")
    public JsonResult auditingSubmit(HttpServletRequest request) throws Exception {

        SysUsers sysUsers = (SysUsers) request.getSession().getAttribute("user");

        if (null == sysUsers) {
            throw new LoginTimeOutException(messageSourceAccessor.getMessage("LoginService.LoginTimeOut", "用户尚未登录或登录失效，请重新登录！"));
        }

        if (StringUtils.isEmpty(request.getParameter("storeID"))) {
            throw new ParameterException(messageSourceAccessor.getMessage("StoreService.StoreIDNotNull", "店铺ID不能为空！"));
        }
        if (StringUtils.isEmpty(request.getParameter("roleID"))) {
            throw new ParameterException(messageSourceAccessor.getMessage("RoleService.RoleIDNotNull", "职位ID不能为空！"));
        }

        int storeID = Integer.parseInt(request.getParameter("storeID"));

        int roleID = Integer.parseInt(request.getParameter("roleID"));

        UserSeller seller = iUserSellerService.selectSellerInfoByUserID(sysUsers.getUserId());

        if (storeID == seller.getSysStore().getId() && roleID == seller.getSysRoles().getRoleId()) {
            return JsonResult.error(messageSourceAccessor.getMessage("UserSellerService.AuditingCanNotRepeat", "不可重复申请！"));
        }

        UserSeller userSeller = new UserSeller();
        userSeller.setUserId(sysUsers.getUserId());
        userSeller.setStoreId(storeID);
        userSeller.setRolesId(roleID);
        userSeller.setEnabled(true);
        userSeller.setStatusId(UserStatus.AUDITING);


        if (iUserSellerService.auditingSubmit(userSeller)) {
            return JsonResult.success();
        } else {
            return JsonResult.error(messageSourceAccessor.getMessage("UserSellerService.AuditingFailed", "申请失败！"));
        }
    }
}
