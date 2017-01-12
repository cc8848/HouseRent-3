package cn.com.showings.service;

import cn.com.showings.pojo.Province;
import cn.com.showings.pojo.SelectPoJo;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/10/9
 * 类说明:
 */
public interface IAddressService {
    List<SelectPoJo> getAllProvince() throws Exception;

    List<SelectPoJo> getCityByProvinceID(int provinceID) throws Exception;

    List<SelectPoJo> getAreaByCityID(int cityID) throws Exception;

    List<SelectPoJo> getAllCity() throws Exception;

    List<Province> getAllAddress() throws Exception;
}
