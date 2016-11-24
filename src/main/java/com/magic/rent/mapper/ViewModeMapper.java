package com.magic.rent.mapper;

import com.magic.rent.pojo.ViewMode;

public interface ViewModeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ViewMode record);

    int insertSelective(ViewMode record);

    ViewMode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ViewMode record);

    int updateByPrimaryKey(ViewMode record);
}