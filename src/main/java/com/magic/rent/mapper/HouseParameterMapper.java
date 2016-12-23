package com.magic.rent.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/23
 * 类说明:
 * 更新记录：
 */
@Repository
public interface HouseParameterMapper {

    List<Map<Integer, String>> getOrientationMap();

    List<Map<Integer, String>> getDecorationMap();

    List<Map<Integer, String>> getTypeMap();
}
