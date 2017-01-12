package cn.com.showings.dao.mapper;

import cn.com.showings.pojo.HouseImage;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseImageMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(HouseImage record);

    int insertSelective(HouseImage record);

    HouseImage selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(HouseImage record);

    int updateByPrimaryKey(HouseImage record);

    HouseImage selectByImageAndUserID(HouseImage houseImage);
}