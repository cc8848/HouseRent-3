package com.magic.rent.mapper;

import com.magic.rent.pojo.Community;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);

    List<Community> selectBySelective(Community community);

    List<Community> selectEnableByUserID(Integer userID);

    int countByStatusForUser(Community community);
}