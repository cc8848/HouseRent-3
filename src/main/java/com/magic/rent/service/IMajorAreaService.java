package com.magic.rent.service;

import com.magic.rent.pojo.MajorArea;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/16
 * 类说明:
 * 更新记录：
 */
public interface IMajorAreaService {

    /**
     * 添加指定用户的擅长地区
     *
     * @param userID 用户ID
     * @param areaID 地区编号
     * @return
     * @throws Exception
     */
    boolean add(int userID, int areaID) throws Exception;

    /**
     * 删除指定用户的擅长地区
     *
     * @param userID 用户ID
     * @param areaID 地区编号
     * @return
     * @throws Exception
     */
    boolean remove(int userID, int areaID) throws Exception;

    List<MajorArea> getMyMajorArea(int userID) throws Exception;
}
