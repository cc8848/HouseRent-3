package com.magic.rent.service.impl;

import com.magic.rent.mapper.CityMapper;
import com.magic.rent.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<String> getCityList(String queryKey, int startNum, int queryNum) throws Exception {
        return null;
    }
}
