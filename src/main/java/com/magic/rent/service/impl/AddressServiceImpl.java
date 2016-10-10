package com.magic.rent.service.impl;

import com.magic.rent.mapper.AreaMapper;
import com.magic.rent.mapper.CityMapper;
import com.magic.rent.mapper.ProvinceMapper;
import com.magic.rent.pojo.Area;
import com.magic.rent.pojo.City;
import com.magic.rent.pojo.Province;
import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Province> provinceList = provinceMapper.selectAllProvince();

        return SelectPoJo.AddressToSelectPoJo(provinceList);
    }

    public List<SelectPoJo> getCityByProvinceID(int provinceID) throws Exception {

        List<City> cityList = cityMapper.selectByProvinceID(provinceID);

        return SelectPoJo.AddressToSelectPoJo(cityList);
    }

    public List<SelectPoJo> getAllCity() throws Exception {

        List<City> cityList = cityMapper.selectAllCity();

        return SelectPoJo.AddressToSelectPoJo(cityList);

    }

    public List<SelectPoJo> getAreaByCityID(int cityID) throws Exception {

        List<Area> areaList = areaMapper.selectByCityID(cityID);

        return SelectPoJo.AddressToSelectPoJo(areaList);
    }
}
