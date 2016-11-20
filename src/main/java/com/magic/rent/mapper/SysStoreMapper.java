package com.magic.rent.mapper;

import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.pojo.SysRoles;
import com.magic.rent.pojo.SysStore;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysStoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysStore record);

    int insertSelective(SysStore record);

    SysStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysStore record);

    int updateByPrimaryKey(SysStore record);

    List<SelectPoJo> selectByAreaID(String areaID);

    List<SelectPoJo> selectRolesByStoreID(int storeID);
}