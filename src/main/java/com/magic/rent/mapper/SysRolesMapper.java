package com.magic.rent.mapper;


import com.magic.rent.pojo.SysRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRolesMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRoles record);

    int insertSelective(SysRoles record);

    SysRoles selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);

    List<SysRoles> selectRolesByUserId(Integer userID);
}