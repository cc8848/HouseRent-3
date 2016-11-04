package com.magic.rent.service.impl;

import com.magic.rent.mapper.RoomsMapper;
import com.magic.rent.pojo.Rooms;
import com.magic.rent.service.IRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wu on 2016/11/4.
 */
@Service
public class RoomsServiceImpl implements IRoomsService {

    @Autowired
    private RoomsMapper roomsMapper;

    public List<Rooms> selectRoomsByHouseID(int houseID) throws Exception {
        return roomsMapper.selectByHouseID(houseID);
    }
}
