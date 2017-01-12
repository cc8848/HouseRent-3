package cn.com.showings.dao.mapper;

import cn.com.showings.pojo.SysUsers;
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