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

        List<Province> provinceList = provinceMapper.selectAllProvince();

        List<SelectPoJo> selectPoJoList = AddressToSelectPoJo(provinceList);

        selectPoJoList.add(0, new SelectPoJo(0, "请选择省份"));

        return selectPoJoList;
    }

    public List<SelectPoJo> getCityByProvinceID(int provinceID) throws Exception {

        List<City> cityList = cityMapper.selectByProvinceID(provinceID);

        List<SelectPoJo> selectPoJoList = AddressToSelectPoJo(cityList);

        selectPoJoList.add(0, new SelectPoJo(0, "请选择城市"));

        return selectPoJoList;
    }

    public List<SelectPoJo> getAllCity() throws Exception {

        List<City> cityList = cityMapper.selectAllCity();

        List<SelectPoJo> selectPoJoList = AddressToSelectPoJo(cityList);

        selectPoJoList.add(0, new SelectPoJo(0, "请选择城市"));

        return selectPoJoList;

    }

    public List<SelectPoJo> getAreaByCityID(int cityID) throws Exception {

        List<Area> areaList = areaMapper.selectByCityID(cityID);

        List<SelectPoJo> selectPoJoList = AddressToSelectPoJo(areaList);

        selectPoJoList.add(0, new SelectPoJo(0, "地区"));

        return selectPoJoList;
    }

    public List<Province> getAllAddress() throws Exception {
        return provinceMapper.selectAllAddress();
    }

    /**
     * 地址转换为选项
     *
     * @param addressList
     * @return
     */
    public static List<SelectPoJo> AddressToSelectPoJo(List<? extends Address> addressList) {
        List<SelectPoJo> selectPoJoList = new ArrayList<SelectPoJo>();
        for (Address address : addressList) {
            SelectPoJo selectPOJO = new SelectPoJo();
            selectPOJO.setId(address.getAddressID());
            selectPOJO.setText(address.getAddressName());
            selectPoJoList.add(selectPOJO);
        }
        return selectPoJoList;
    }
}
