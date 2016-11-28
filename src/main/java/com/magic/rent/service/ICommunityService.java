package com.magic.rent.service;

import com.magic.rent.pojo.Community;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明:社区相关服务
 * 更新记录：
 */
public interface ICommunityService {

    boolean createProject(Community community, int userID) throws Exception;

    boolean passProject(Community community) throws Exception;
}
