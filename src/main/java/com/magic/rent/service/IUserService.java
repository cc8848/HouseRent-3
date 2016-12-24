package com.magic.rent.service;

import com.magic.rent.pojo.SysUsers;
import org.springframework.web.multipart.MultipartFile;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明: 用户相关服务接口
 * 更新记录：
 */
public interface IUserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     * @throws Exception
     */
    SysUsers findSysUserByUserName(String userName) throws Exception;

    /**
     * 根据用户ID查找用户
     *
     * @param userID
     * @return 用户信息
     */
    SysUsers findUserByUserID(int userID) throws Exception;

    /**
     * @param newPwd   新密码
     * @param oldPwd   原密码
     * @param sysUsers 用户名
     * @return
     * @throws Exception
     */
    boolean changePassword(String newPwd, String oldPwd, SysUsers sysUsers) throws Exception;

    /**
     * 更新用户登录信息
     *
     * @param sysUsers 用户信息
     * @return 用户ID
     * @throws Exception
     */
    int updateUserLoginInfo(SysUsers sysUsers) throws Exception;

    /**
     * 用户注册
     *
     * @param sysUsers 用户信息
     * @return
     */
    boolean register(SysUsers sysUsers) throws Exception;

    /**
     * 修改用户信息
     *
     * @param sysUsers 用户信息
     * @return
     * @throws Exception
     */
    boolean modify(SysUsers sysUsers) throws Exception;

    /**
     * 头像文件保存服务
     *
     * @param multipartFile 分部文件
     * @param userID        用户ID
     * @param x             截图原点X坐标
     * @param y             截图原点Y坐标
     * @param w             截图宽度
     * @param h             截图高度
     * @param sw            图片缩放后宽度
     * @param sh            图片缩放后高度（此处不可使用此高度，依照现在的前端实现来说不精确。）
     * @return 头像图片SRC地址
     * @throws Exception
     */
    String savePortrait(MultipartFile multipartFile, Integer userID, int x, int y, int w, int h, int sw, int sh) throws Exception;

    /**
     * 检查用户状态
     *
     * @param sysUsers 用户信息
     * @return
     * @throws Exception
     */
    boolean statusCheck(SysUsers sysUsers) throws Exception;
}
