package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.CompanyMapper;
import com.magic.rent.pojo.Company;
import com.magic.rent.service.security.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean create(Company company) throws Exception {
        //校验用户是否已经开通了企业服务
        Integer companyID = companyMapper.selectByUserID(company.getDeveloperId());

        if (null == companyID) {
            int rows = companyMapper.insert(company);
            return rows > 0;
        } else {
            throw new BusinessException("一个账户只能为一家公司开通企业服务！");
        }
    }
}
