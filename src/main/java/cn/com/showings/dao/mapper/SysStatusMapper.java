package cn.com.showings.dao.mapper;

import cn.com.showings.pojo.SysStatus;

public interface SysStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysStatus record);

    int insertSelective(SysStatus record);

    SysStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysStatus record);

    int updateByPrimaryKey(SysStatus record);
}