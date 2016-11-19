package com.magic.rent.service;

import com.magic.rent.pojo.HouseStatus;

/**
 * Created by wu on 2016/11/6.
 */
public interface IHouseStatusService {
    HouseStatus selectByHouseStatusID(int id) throws Exception;
}
