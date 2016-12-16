package com.magic.rent.mapper;

import com.magic.rent.pojo.MajorArea;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorArea record);

    int insertSelective(MajorArea record);

    MajorArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorArea record);

    int updateByPrimaryKey(MajorArea record);

    List<MajorArea> selectBySelective(MajorArea majorArea);

    int countByUser(Integer userID);
}