package com.magic.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.CommunityMapper;
import com.magic.rent.mapper.CompanyMapper;
import com.magic.rent.pojo.AuditingStatus;
import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.Company;
import com.magic.rent.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明: 关于社区项目的相关服务
 * 更新记录：
 */
@Service
public class CommunityService implements ICommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CompanyMapper companyMapper;


    public boolean create(Community community, int userID) throws Exception {
        int count = countClassifyCommunity(AuditingStatus.AUDITING, userID);
        if (count >= 3) {
            throw new BusinessException("本公司在途申请不可超过3笔！请删除在途申请后再发起新的申请！");
        }
        //根据用户查询用户所在公司
        Company query = new Company();
        query.setDeveloperId(userID);
        query.setStatus(AuditingStatus.SUCCESS);
        List<Company> companyList = companyMapper.selectBySelective(query);
        Company company = companyList.get(0);

        if (null != company) {
            community.setCompanyId(company.getId());
            community.setStatus(AuditingStatus.AUDITING);
        } else {
            throw new BusinessException("当前账户尚未开通企业服务！");
        }
        community.setAuditingTime(new Date());
        int rows = communityMapper.insert(community);
        return rows > 0;
    }

    public boolean pass(int communityID) throws Exception {
        Community community = new Community();
        community.setId(communityID);
        community.setStatus(AuditingStatus.SUCCESS);
        community.setOperateTime(new Date());
        int rows = communityMapper.updateByPrimaryKeySelective(community);

        return rows > 0;
    }

    public boolean cancel(int communityID, int userID) throws Exception {
        //查询用户所在公司信息
        Company queryCompany = new Company();
        queryCompany.setDeveloperId(userID);
        List<Company> companyList = companyMapper.selectBySelective(queryCompany);
        //校验公司信息是否存在
        if (null == companyList || companyList.size() == 0) {
            throw new BusinessException("用户尚未开通企业服务！");
        }

        Company company = companyList.get(0);
        Community query = new Community();
        query.setStatus(AuditingStatus.AUDITING);
        query.setCompanyId(company.getId());
        List<Community> communityList = communityMapper.selectBySelective(query);
        //校验用户是否发起过申请
        if (null == communityList || communityList.size() == 0) {
            throw new BusinessException("用户尚未申请创建社区项目！");
        }
        //遍历找出要操作取消的那一笔
        boolean flag = false;
        for (Community DBCommunity : communityList) {
            if (DBCommunity.getId().equals(communityID)) {
                flag = true;
                Community community = new Community();
                community.setId(communityID);
                community.setStatus(AuditingStatus.CANCEL);
                community.setOperateTime(new Date());
                int rows = communityMapper.updateByPrimaryKeySelective(community);
                return rows > 0;
            }
        }
        if (!flag) {
            throw new BusinessException("未包含任何在途申请，无法取消！");
        }
        return false;
    }

    public boolean refuse(int communityID) throws Exception {
        Community community = new Community();
        community.setId(communityID);
        community.setStatus(AuditingStatus.REFUSE);
        community.setOperateTime(new Date());
        int rows = communityMapper.updateByPrimaryKeySelective(community);

        return rows > 0;
    }

    public PageInfo<Community> getClassifyCommunities(int status, int pageNum, int pageSize) throws Exception {
        Community community = new Community();
        community.setStatus(status);
        PageHelper.startPage(pageNum, pageSize);
        List<Community> communityList = communityMapper.selectBySelective(community);
        return new PageInfo<Community>(communityList);
    }

    public List<Community> getSuccessCommunities(int userID) throws Exception {
        return communityMapper.selectEnableByUserID(userID);
    }

    public int countClassifyCommunity(int status, int userID) throws Exception {
        Company query = new Company();
        query.setDeveloperId(userID);
        List<Company> companyList = companyMapper.selectBySelective(query);
        Company company = companyList.get(0);

        Community community = new Community();
        community.setStatus(status);
        community.setCompanyId(company.getId());
        return communityMapper.countByStatusForUser(community);
    }
}
