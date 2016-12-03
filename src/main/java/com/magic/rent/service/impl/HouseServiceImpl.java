package com.magic.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.*;
import com.magic.rent.pojo.*;
import com.magic.rent.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 2016/10/13
 * 类说明:
 */
@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CommunityMapper communityMapper;

    public boolean create(House house, int userID) throws Exception {

        //校验是否有开通企业服务
        Company query = new Company();
        query.setDeveloperId(userID);
        query.setStatus(SysStatus.SUCCESS);
        List<Company> resultList = companyMapper.selectBySelective(query);
        if (null == resultList || resultList.size() == 0) {
            throw new BusinessException("用户尚未开通企业服务！");
        }

        //校验操作的是否本项目下的房源
        Company company = resultList.get(0);
        Community queryCommunity = new Community();
        queryCommunity.setCompanyId(company.getId());
        queryCommunity.setCompanyId(house.getCommunityId());
        List<Community> communityList = communityMapper.selectBySelective(queryCommunity);

        if (null == communityList || communityList.size() == 0) {
            throw new BusinessException("不可为本公司以外的其他项目添加房源！");
        } else {
            house.setSysStatus(SysStatus.AUDITING);
            house.setAuditingTime(new Date());
            return houseMapper.insert(house) > 0;
        }
    }

    public boolean cancel(int houseID, int communityID, int userID) throws Exception {
        //校验是否有开通企业服务
        Company queryCompany = new Company();
        queryCompany.setDeveloperId(userID);
        queryCompany.setStatus(SysStatus.SUCCESS);
        List<Company> companyList = companyMapper.selectBySelective(queryCompany);
        if (null == companyList || companyList.size() == 0) {
            throw new BusinessException("用户尚未开通企业服务！");
        }

        //校验操作的是否为本公司的社区
        Community queryCommunity = new Community();
        queryCommunity.setId(communityID);
        queryCommunity.setCompanyId(companyList.get(0).getId());
        queryCommunity.setStatus(SysStatus.SUCCESS);
        List<Community> communityList = communityMapper.selectBySelective(queryCommunity);
        if (null == communityList || communityList.size() == 0) {
            throw new BusinessException("不可操作本公司以外的其他社区！");
        }

        House queryHouse = new House();
        queryHouse.setId(houseID);
        queryHouse.setSysStatus(SysStatus.AUDITING);
        List<House> houseList = houseMapper.selectBySelective(queryHouse);

        if (null == houseList || houseList.size() == 0) {
            throw new BusinessException("此房源尚未处于审核状态，无法取消！");
        } else {
            House house = new House();
            house.setId(houseID);
            house.setSysStatus(SysStatus.CANCEL);
            house.setOperateTime(new Date());
            return houseMapper.updateByPrimaryKeySelective(house) > 0;
        }
    }

    public boolean pass(int houseID) throws Exception {
        House house = new House();
        house.setId(houseID);
        house.setSysStatus(SysStatus.SUCCESS);
        house.setOperateTime(new Date());
        return houseMapper.updateByPrimaryKeySelective(house) > 0;
    }

    public boolean refuse(int houseID) throws Exception {
        House house = new House();
        house.setId(houseID);
        house.setSysStatus(SysStatus.REFUSE);
        house.setOperateTime(new Date());
        return houseMapper.updateByPrimaryKeySelective(house) > 0;
    }

    public boolean update(House house, int userID) throws Exception {
        return false;
    }

    public PageInfo<House> getCommunityHouses(int communityID, int pageSize, int pageNum) throws Exception {
        House queryHouse = new House();
        queryHouse.setCommunityId(communityID);
        PageHelper.startPage(pageNum, pageSize);
        List<House> houseList = houseMapper.selectBySelective(queryHouse);
        return new PageInfo<House>(houseList);
    }

    public PageInfo<House> getAllHouses(int companyID, int pageSize, int pageNum) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<House> houseList = houseMapper.selectByCompanyID(companyID);
        return new PageInfo<House>(houseList);
    }

    public House getDetail(int houseID) throws Exception {

        return houseMapper.selectDetailsByPrimaryKey(houseID);
    }
}
