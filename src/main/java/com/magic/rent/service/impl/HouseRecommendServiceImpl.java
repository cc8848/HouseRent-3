package com.magic.rent.service.impl;

import com.magic.rent.mapper.HouseRecommendMapper;
import com.magic.rent.pojo.HouseRecommend;
import com.magic.rent.service.IHouseRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wu on 2016/10/17.
 */
@Service
public class HouseRecommendServiceImpl implements IHouseRecommendService {

    @Autowired
    private HouseRecommendMapper houseRecommendMapper;

    public HouseRecommend selectTodayRecommend() {

        HouseRecommend houseRecommend = new HouseRecommend();
        houseRecommend.setDate(new Date());

        return houseRecommendMapper.selectByRecommendDate(houseRecommend);
    }
}
