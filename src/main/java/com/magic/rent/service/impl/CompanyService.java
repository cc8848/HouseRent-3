package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.CompanyMapper;
import com.magic.rent.mapper.UsersRelateRolesMapper;
import com.magic.rent.pojo.SysStatus;
import com.magic.rent.pojo.Company;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.UsersRelateRoles;
import com.magic.rent.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明:家访问控制器
 * 更新记录：
 */
@Service
public class CompanyService implements ICompanyService {


    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private UsersRelateRolesMapper usersRelateRolesMapper;

    public boolean create(Company company) throws Exception {
        //校验用户是否已经开通了企业服务
        Company query = new Company();
        query.setDeveloperId(company.getDeveloperId());
        List<Company> companyList = companyMapper.selectBySelective(query);

        boolean flag = true;//用于判断是否包含在途申请或已经申请成功的企业服务
        for (Company DBCompany : companyList) {
            int status = DBCompany.getStatus();
            switch (status) {
                case SysStatus.AUDITING:
                case SysStatus.SUCCESS:
                    flag = false;
                    break;
            }
            if (!flag) {
                //只要存在在途的申请或已经成功的申请，则跳出循环
                break;
            }
        }
        if (flag) {
            Date date = new Date();
            company.setAuditingTime(date);
            company.setStatus(SysStatus.AUDITING);
            int rows = companyMapper.insert(company);
            return rows > 0;
        } else {
            throw new BusinessException("一个账户只能为一家公司开通企业服务！");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean pass(int companyID) throws Exception {
        Company company = new Company();
        company.setId(companyID);
        company.setStatus(SysStatus.SUCCESS);
        Date date = new Date();
        company.setOperateTime(date);
        int rows = companyMapper.updateByPrimaryKeySelective(company);
        if (rows <= 0) {
            throw new BusinessException("更新公司信息失败！");
        }
        //查询用户ID以进行角色更新
        List<Company> query = companyMapper.selectBySelective(company);
        int userID = query.get(0).getDeveloperId();
        UsersRelateRoles usersRelateRoles = new UsersRelateRoles();
        usersRelateRoles.setRoleId(SysRoles.DEVELOPER);
        usersRelateRoles.setUserId(userID);
        int rows2 = usersRelateRolesMapper.insert(usersRelateRoles);
        if (rows2 <= 0) {
            throw new BusinessException("创建用户角色失败！");
        }
        return true;
    }

    public boolean cancel(int companyID, int userID) throws Exception {
        //设置查询条件
        Company query = new Company();
        query.setDeveloperId(userID);
        query.setStatus(SysStatus.AUDITING);
        List<Company> companyList = companyMapper.selectBySelective(query);
        if (null == companyList || companyList.size() == 0) {
            throw new BusinessException("此账户尚未申请开通企业服务，无法取消！");
        }
        //遍历查询结果
        boolean flag = false;
        for (Company DBCompany : companyList) {
            //遍历结果，获取正在申请的公司
            if (DBCompany.getId().equals(companyID)) {
                flag = true;
                Company company = new Company();
                company.setId(companyID);
                company.setStatus(SysStatus.CANCEL);
                company.setOperateTime(new Date());
                int rows = companyMapper.updateByPrimaryKeySelective(company);
                return rows > 0;
            }
        }
        if (!flag) {
            throw new BusinessException("未包含在途的申请，无法取消");
        }

        return false;
    }

    public boolean refuse(int companyID) throws Exception {
        Company company = new Company();
        company.setId(companyID);
        company.setStatus(SysStatus.REFUSE);
        company.setOperateTime(new Date());

        int rows = companyMapper.updateByPrimaryKeySelective(company);

        return rows > 0;
    }

    public List<Company> getAuditingCompanies() throws Exception {
        Company company = new Company();
        company.setStatus(SysStatus.AUDITING);
        return companyMapper.selectBySelective(company);
    }

    public Company getCurrentCompanyInfo(int userID) throws Exception {
        Company query = new Company();
        query.setDeveloperId(userID);
        return companyMapper.selectCurrentCompanyInfo(userID);
    }

    public Company getDetail(int companyID) throws Exception {
        Company company=companyMapper.selectByPrimaryKey(companyID);
        if (null==company){
            throw new BusinessException("所查询的公司不存在！");
        }else {
            return company;
        }
    }
}
