package com.magic.rent.service;

import com.magic.rent.pojo.RentMode;

import java.util.List;

/**
 * Created by wu on 2016/11/4.
 */
public interface IRentModeService {
    List<RentMode> selectRentModesByHouseID(int houseID) throws Exception;
}
