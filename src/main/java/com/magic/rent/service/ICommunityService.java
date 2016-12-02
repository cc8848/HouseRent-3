package com.magic.rent.service;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.Company;
import com.magic.rent.pojo.SelectPoJo;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明:社区相关服务
 * 更新记录：
 */
public interface ICommunityService {

    boolean create(Community community, int userID) throws Exception;

    boolean cancel(int communityID, int companyID) throws Exception;

    boolean pass(int communityID) throws Exception;

    boolean refuse(int communityID) throws Exception;

    PageInfo<Community> getClassifyCommunities(Integer status, Integer userID, int pageNum, int pageSize) throws Exception;

    List<Community> getSuccessCommunities(int userID) throws Exception;

    List<SelectPoJo> getSuccessCommunitiesForSelect(int userID) throws Exception;

    int countClassifyCommunity(int status, int userID) throws Exception;
}
