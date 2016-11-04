package com.magic.rent.service;

import com.magic.rent.pojo.Rooms;

import java.util.List;

/**
 * Created by wu on 2016/11/4.
 */
public interface IRoomsService {
    List<Rooms> selectRoomsByHouseID(int houseID) throws Exception;
}
