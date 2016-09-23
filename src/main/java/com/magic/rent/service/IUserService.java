package com.magic.rent.service;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
public interface IUserService {
    /**
     * 根据ID查询用户数据
     *
     * @return 用户信息
     * @throws Exception
     */
    User findUserByID(User user) throws Exception;

    /**
     * 查询电话号码是否已存在
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean phoneIsExist(User user) throws Exception;

    /**
     * 进行登录校验,如果成功则返回用户信息,失败则返回Null
     *
     * @param user
     * @return
     * @throws Exception
     */
    User loginCheck(User user) throws Exception;
}
