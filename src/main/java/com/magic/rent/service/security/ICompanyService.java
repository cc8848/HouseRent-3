package com.magic.rent.service.security;

import com.magic.rent.pojo.Company;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/11/28
 * 类说明:公司业务接口
 * 更新记录：
 */
public interface ICompanyService {

    boolean create(Company company) throws Exception;
}
