package com.magic.rent.service.impl;

import com.magic.rent.service.IIDInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/19
 * 类说明:
 */
@Service
public class IDInfoServiceImpl implements IIDInfoService {
    @Autowired
    private IDInfoMapper idInfoMapper;

    public List<IDInfo> findALLIDInfo() {
        return idInfoMapper.selectALLIDInfo();
    }
}
