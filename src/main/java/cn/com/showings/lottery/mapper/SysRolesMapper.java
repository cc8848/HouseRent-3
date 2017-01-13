package cn.com.showings.lottery.mapper;


import cn.com.showings.lottery.pojo.SysRoles;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysRolesMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRoles record);

    int insertSelective(SysRoles record);

    SysRoles selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);

    List<SysRoles> selectRolesByUserId(Integer userID);

    int insertRolesByUserID(Map<String, Integer> userAndRole);

    List<Integer> selectRolesIDByUserID(int userID);

    int deleteUsersRoleByUserIDAndRoleID(Map<String, Integer> userAndRole);
}