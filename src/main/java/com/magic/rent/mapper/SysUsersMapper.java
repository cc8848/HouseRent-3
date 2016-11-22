package com.magic.rent.mapper;


import com.magic.rent.pojo.SysUsers;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    SysUsers selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);

    SysUsers selectBySelective(SysUsers sysUsers);

    SysUsers selectByUserName(String userName);


}