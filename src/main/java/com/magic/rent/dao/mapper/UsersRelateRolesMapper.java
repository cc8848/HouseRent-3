package com.magic.rent.dao.mapper;

import com.magic.rent.pojo.UsersRelateRoles;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRelateRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersRelateRoles record);

    int insertSelective(UsersRelateRoles record);

    UsersRelateRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsersRelateRoles record);

    int updateByPrimaryKey(UsersRelateRoles record);
}