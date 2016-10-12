package com.magic.rent.mapper;

import com.magic.rent.pojo.Community;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityMapper {
    int deleteByPrimaryKey(int id);

    int insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);
}