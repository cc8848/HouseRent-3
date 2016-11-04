package com.magic.rent.service.impl;

import com.magic.rent.mapper.RentModeMapper;
import com.magic.rent.pojo.RentMode;
import com.magic.rent.service.IRentModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wu on 2016/11/4.
 */
@Service
public class RentModeServiceImpl implements IRentModeService {
    @Autowired
    private RentModeMapper rentModeMapper;

    public List<RentMode> selectRentModesByHouseID(int houseID) throws Exception {
        return rentModeMapper.selectByHouseID(houseID);
    }
}
