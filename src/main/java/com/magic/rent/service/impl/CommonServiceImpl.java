package com.magic.rent.service.impl;

import com.magic.rent.mapper.CityMapper;
import com.magic.rent.pojo.City;
import com.magic.rent.pojo.Province;
import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.service.ICommonService;
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
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private CityMapper cityMapper;

    public List<SelectPoJo> getCityByProvinceName(Province province) throws Exception {

        List<City> cityList = cityMapper.selectByProvinceName(province.getProvincename());

        return cityListToSelectPojoList(cityList);
    }

    public List<SelectPoJo> getAllCity() throws Exception {

        List<City> cityList = cityMapper.selectAllCity();

        return cityListToSelectPojoList(cityList);

    }

    /**
     * 将城市列表转换为SelectPojo列表
     *
     * @param cityList
     * @return
     */
    private List<SelectPoJo> cityListToSelectPojoList(List<City> cityList) {
        List<SelectPoJo> selectPoJoList = new ArrayList<SelectPoJo>();

        for (City city : cityList) {
            SelectPoJo selectPOJO = new SelectPoJo();
            selectPOJO.setId(city.getCityid());
            selectPOJO.setText(city.getCityname());
            selectPoJoList.add(selectPOJO);
        }

        return selectPoJoList;
    }
}
