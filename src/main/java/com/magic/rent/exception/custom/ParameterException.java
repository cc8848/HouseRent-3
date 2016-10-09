package com.magic.rent.exception.custom;

import com.magic.rent.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/29
 * 类说明:
 */
public class ParameterException extends BaseException {

    public ParameterException(String message) {
        super(message);
    }
}
