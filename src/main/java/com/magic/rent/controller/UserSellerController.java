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

        UserSeller userSeller = new UserSeller();
        userSeller.setUserId(sysUsers.getUserId());
        userSeller.setStoreId(storeID);
        userSeller.setRolesId(roleID);
        userSeller.setEnabled(true);
        userSeller.setStatusId(UserStatus.AUDITING);//不论修改还是新增都需要进入审核状态

        if (null != seller && storeID == seller.getSysStore().getId() && roleID == seller.getSysRoles().getRoleId()) {
            //重复性验证：seller存在，且店铺ID和角色ID都相同的情况下，不可再次申请
            return JsonResult.error(messageSourceAccessor.getMessage("UserSellerService.AuditingCanNotRepeat", "不可重复申请！"));
        } else if (null != seller && ((storeID != seller.getSysStore().getId() || roleID != seller.getSysRoles().getRoleId()) || (storeID != seller.getSysStore().getId() && roleID != seller.getSysRoles().getRoleId()))) {
            //修改：当Seller存在，且店铺id和岗位ID有一个不同，或全部不同的情况下，进行修改操作

            userSeller.setId(seller.getId());//修改时必须放入主键ID
            if (iUserSellerService.auditingUpdate(userSeller)) {
                return JsonResult.success();
            } else {
                return JsonResult.error(messageSourceAccessor.getMessage("UserSellerService.AuditingUpdateFailed", "修改失败！"));
            }
        } else {
            //新增：当Seller不存在，则进行新增操作
            if (iUserSellerService.auditingSubmit(userSeller)) {
                return JsonResult.success();
            } else {
                return JsonResult.error(messageSourceAccessor.getMessage("UserSellerService.AuditingAddFailed", "申请失败！"));
            }
        }
    }

    @ResponseBody
    @RequestMapping("/secede")
    public JsonResult secede(HttpServletRequest request) throws Exception {
        SysUsers sysUsers = (SysUsers) request.getSession().getAttribute("user");

        if (null == sysUsers) {
            throw new LoginTimeOutException(messageSourceAccessor.getMessage("LoginService.LoginTimeOut", "用户尚未登录或登录失效，请重新登录！"));
        }

        UserSeller seller = iUserSellerService.selectSellerInfoByUserID(sysUsers.getUserId());

        if (null == seller) {
            //重复性操作验证
            return JsonResult.error(messageSourceAccessor.getMessage("UserSellerService.AuditingSecedeCanNotRepeat", "您已经退出团队不可重复操作！"));
        } else {
            if (iUserSellerService.auditingSecede(sysUsers.getUserId())) {
                return JsonResult.success();
            } else {
                return JsonResult.error(messageSourceAccessor.getMessage("UserSellerService.AuditingSecedeFailed", "退出失败！"));
            }
        }
    }

    @ResponseBody
    @RequestMapping("/pass")
    public JsonResult pass(HttpServletRequest request) throws Exception {

        if (StringUtils.isEmpty(request.getParameter("userID"))) {
            throw new ParameterException(messageSourceAccessor.getMessage("UserSellerService.UserIDNotNull", "用户ID不能为空！"));
        }

        UserSeller userSeller = new UserSeller();
        userSeller.setUserId(Integer.parseInt(request.getParameter("userID")));
        userSeller.setStatusId(UserStatus.SUCCESS);

        if (iUserSellerService.auditingPass(userSeller)) {
            return JsonResult.error("审核通过失败！");
        } else {
            //更新Session中的用户信息
            return JsonResult.success();
        }
    }

    @ResponseBody
    @RequestMapping("/refuse")
    public JsonResult refuse(HttpServletRequest request) throws Exception {
        if (StringUtils.isEmpty(request.getParameter("userID"))) {
            throw new ParameterException(messageSourceAccessor.getMessage("UserSellerService.UserIDNotNull", "用户ID不能为空！"));
        }

        UserSeller userSeller = new UserSeller();
        userSeller.setUserId(Integer.parseInt(request.getParameter("userID")));
        userSeller.setStatusId(UserStatus.REFUSE);

        if (iUserSellerService.auditingRefuse(userSeller)) {
            return JsonResult.error("审核拒绝失败！");
        } else {
            //更新Session中的用户信息
            return JsonResult.success();
        }
    }
}
