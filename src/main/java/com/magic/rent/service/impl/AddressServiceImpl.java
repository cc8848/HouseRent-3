package com.magic.rent.service.impl;

import com.magic.rent.mapper.AreaMapper;
import com.magic.rent.mapper.CityMapper;
import com.magic.rent.mapper.ProvinceMapper;
import com.magic.rent.pojo.*;
import com.magic.rent.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/10/9
 * 类说明:
 */
@Service
public class AddressServiceImpl implements IAddressService {


    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private AreaMapper areaMapper;

    public List<SelectPoJo> getAllProvince() throws Exception {

        List<SelectPoJo> provinceList = provinceMapper.selectAllProvince();

        provinceList.add(0, new SelectPoJo(0, "请选择省份"));

        return provinceList;
    }

    public List<SelectPoJo> getCityByProvinceID(int provinceID) throws Exception {

        List<SelectPoJo> cityList = cityMapper.selectByProvinceID(provinceID);

        cityList.add(0, new SelectPoJo(0, "请选择城市"));

        return cityList;
    }

    public List<SelectPoJo> getAllCity() throws Exception {

        List<SelectPoJo> cityList = cityMapper.selectAllCity();

        cityList.add(0, new SelectPoJo(0, "请选择城市"));

        return cityList;

    }

    public List<SelectPoJo> getAreaByCityID(int cityID) throws Exception {

        List<SelectPoJo> areaList = areaMapper.selectByCityID(cityID);

        areaList.add(0, new SelectPoJo(0, "地区"));

        return areaList;
    }

    public List<Province> getAllAddress() throws Exception {
        return provinceMapper.selectAllAddress();
    }

}
