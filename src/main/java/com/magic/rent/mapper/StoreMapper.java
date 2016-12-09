package com.magic.rent.mapper;

import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.pojo.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    List<Store> selectBySelective(Store store);

    Store selectCurrentStoreInfo(int userID);

    List<SelectPoJo> selectByArea(int areaID);
}