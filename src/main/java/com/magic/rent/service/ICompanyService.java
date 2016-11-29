package com.magic.rent.service;

import com.magic.rent.pojo.Company;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明:公司业务接口
 * 更新记录：
 */
public interface ICompanyService {

    boolean create(Company company) throws Exception;

    boolean cancel(int companyID, int userID) throws Exception;

    boolean pass(int companyID) throws Exception;

    boolean refuse(int companyID) throws Exception;

    List<Company> getAuditingCompanies() throws Exception;

    Company getCurrentCompanyInfo(int userID) throws Exception;

}
