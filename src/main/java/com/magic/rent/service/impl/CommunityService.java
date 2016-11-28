package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.CommunityMapper;
import com.magic.rent.mapper.CompanyMapper;
import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.Company;
import com.magic.rent.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明:家访问控制器
 * 更新记录：
 */
@Service
public class CommunityService implements ICommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CompanyMapper companyMapper;


    public boolean createProject(Community community, int userID) throws Exception {
        //根据用户查询用户所在公司
        Integer companyID = companyMapper.selectByUserID(userID);
        if (null != companyID) {
            community.setCompanyId(companyID);
        } else {
            throw new BusinessException("当前账户尚未开通企业服务！");
        }
        int rows = communityMapper.insert(community);
        return rows > 0;
    }

    public boolean passProject(Community community) throws Exception {

        int rows = communityMapper.updateByPrimaryKeySelective(community);

        return rows > 0;
    }
}
