package cn.com.showings.lottery.mapper;

import cn.com.showings.lottery.pojo.SysStatus;

public interface SysStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysStatus record);

    int insertSelective(SysStatus record);

    SysStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysStatus record);

    int updateByPrimaryKey(SysStatus record);
}