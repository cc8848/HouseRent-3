package com.magic.rent.mapper;

import com.magic.rent.pojo.IDInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Repository
public interface IDInfoMapper {

    List<IDInfo> selectALLIDInfo();


}
