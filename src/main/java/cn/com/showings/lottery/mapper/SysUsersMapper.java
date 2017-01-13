package cn.com.showings.lottery.mapper;

import cn.com.showings.lottery.pojo.SysUsers;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    SysUsers selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);

    SysUsers selectByUserName(String userName);
}