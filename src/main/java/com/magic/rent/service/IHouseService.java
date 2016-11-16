package com.magic.rent.service;

import com.github.pagehelper.PageInfo;
import com.magic.rent.pojo.Community;
import com.magic.rent.pojo.House;

import java.util.List;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 2016/10/13
 * 类说明:
 */
public interface IHouseService {

    PageInfo<House> selectByCommunity(Community community, int pageNum, int pageSize) throws Exception;

    PageInfo<House> selectBySearchTerms(Map<String, Object> parameterMap, int pageNum, int pageSize) throws Exception;

    House selectByHouseID(int houseID) throws Exception;

    PageInfo<Map<String, String>> selectNearHouse(House house, int pageNum, int pageSize) throws Exception;
}
