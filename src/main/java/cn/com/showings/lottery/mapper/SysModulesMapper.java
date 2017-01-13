package cn.com.showings.lottery.mapper;


import cn.com.showings.lottery.pojo.SysModules;

public interface SysModulesMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(SysModules record);

    int insertSelective(SysModules record);

    SysModules selectByPrimaryKey(Integer moduleId);

    int updateByPrimaryKeySelective(SysModules record);

    int updateByPrimaryKey(SysModules record);
}