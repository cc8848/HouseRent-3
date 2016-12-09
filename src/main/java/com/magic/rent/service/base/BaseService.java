package com.magic.rent.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/23
 * 类说明:基础服务类，描述服务类的共通部分
 * 更新记录：
 */
public class BaseService {

    @Autowired
    protected MessageSourceAccessor messageSourceAccessor;
}
