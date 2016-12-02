package com.magic.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.CommunityMapper;
import com.magic.rent.mapper.CompanyMapper;
import com.magic.rent.pojo.SysStatus;
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

    /**
     * 创建社区，其中需要对在途申请的社区数量做控制
     *
     * @param community
     * @param userID
     * @return
     * @throws Exception
     */
    public boolean create(Community community, int userID) throws Exception {
        int count = countClassifyCommunity(SysStatus.AUDITING, userID);
        if (count >= 3) {
            throw new BusinessException("本公司在途申请不可超过3笔！请删除在途申请后再发起新的申请！");
        }
        //根据用户查询用户所在公司
        Company query = new Company();
        query.setDeveloperId(userID);
        query.setStatus(SysStatus.SUCCESS);
        List<Company> companyList = companyMapper.selectBySelective(query);
        Company company = companyList.get(0);

        if (null != company) {
            community.setCompanyId(company.getId());
            community.setStatus(SysStatus.AUDITING);
        } else {
            throw new BusinessException("当前账户尚未开通企业服务！");
        }
        community.setAuditingTime(new Date());
        int rows = communityMapper.insert(community);
        return rows > 0;
    }

    /**
     * 审核通过
     *
     * @param communityID
     * @return
     * @throws Exception
     */
    public boolean pass(int communityID) throws Exception {
        Community community = new Community();
        community.setId(communityID);
        community.setStatus(SysStatus.SUCCESS);
        community.setOperateTime(new Date());
        int rows = communityMapper.updateByPrimaryKeySelective(community);

        return rows > 0;
    }

    /**
     * 用户自行取消在途的申请，
     * 方法内有校验用户所取消的项目，是否属于自己的项目
     *
     * @param communityID
     * @param userID
     * @return
     * @throws Exception
     */
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
        query.setStatus(SysStatus.AUDITING);
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
                community.setStatus(SysStatus.CANCEL);
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

    /**
     * 拒绝申请
     *
     * @param communityID
     * @return
     * @throws Exception
     */
    public boolean refuse(int communityID) throws Exception {
        Community community = new Community();
        community.setId(communityID);
        community.setStatus(SysStatus.REFUSE);
        community.setOperateTime(new Date());
        int rows = communityMapper.updateByPrimaryKeySelective(community);

        return rows > 0;
    }

    /**
     * 获取所有不同状态下的社区列表
     * 可指定用户，指定状态，也可查询全部
     *
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageInfo<Community> getClassifyCommunities(Integer status, Integer userID, int pageNum, int pageSize) throws Exception {
        Community community = new Community();
        if (null != status) {
            community.setStatus(status);
        }
        if (null != userID) {
            Company query = new Company();
            query.setDeveloperId(userID);
            List<Company> result = companyMapper.selectBySelective(query);
            if (null != result.get(0).getId()) {
                community.setCompanyId(result.get(0).getId());
            } else {
                throw new BusinessException("该用户尚未开通企业服务！");
            }
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Community> communityList = communityMapper.selectBySelective(community);
        return new PageInfo<Community>(communityList);
    }

    /**
     * 获取用户账户下已经申请成功的社区列表
     *
     * @param userID
     * @return
     * @throws Exception
     */
    public List<Community> getSuccessCommunities(int userID) throws Exception {
        return communityMapper.selectEnableByUserID(userID);
    }

    /**
     * 计算当前用户账户下不同状态的房屋的数量
     * 主要是用于发布房源时，控制在途申请的最大数量，以减少垃圾数据
     *
     * @param status
     * @param userID
     * @return
     * @throws Exception
     */
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
