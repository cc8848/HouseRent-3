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

    int issueHouse(House house, int userID) throws Exception;

    boolean saveFile(int houseID, int viewMode, String newFileName, String oldFileName) throws Exception;

    Map<String, Object> showHouseDetails(int houseID) throws Exception;
}
