package com.magic.rent.mapper;

import com.magic.rent.pojo.SysCompany;
import org.springframework.stereotype.Repository;

@Repository
public interface SysCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysCompany record);

    int insertSelective(SysCompany record);

    SysCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysCompany record);

    int updateByPrimaryKey(SysCompany record);
}