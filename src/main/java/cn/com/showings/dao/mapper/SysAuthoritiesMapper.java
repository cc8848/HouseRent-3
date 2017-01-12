package cn.com.showings.dao.mapper;

import cn.com.showings.pojo.SysAuthorities;
import cn.com.showings.pojo.SysRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysAuthoritiesMapper {
    int deleteByPrimaryKey(Integer authorityId);

    int insert(SysAuthorities record);

    int insertSelective(SysAuthorities record);

    SysAuthorities selectByPrimaryKey(Integer authorityId);

    int updateByPrimaryKeySelective(SysAuthorities record);

    int updateByPrimaryKey(SysAuthorities record);

    List<SysAuthorities> selectByRole(SysRoles sysRoles);
}