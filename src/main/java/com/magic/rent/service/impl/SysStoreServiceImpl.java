package com.magic.rent.service.impl;

import com.magic.rent.mapper.SysStoreMapper;
import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.service.ISysStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wu on 2016/11/19.
 */
@Service
public class SysStoreServiceImpl implements ISysStoreService {

    @Autowired
    private SysStoreMapper sysStoreMapper;

    public List<SelectPoJo> selectStoreNumByAreaID(String areaID) throws Exception {

        return sysStoreMapper.selectByAreaID(areaID);
    }
}
