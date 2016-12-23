package com.magic.rent.exception.custom;

import java.io.Serializable;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/23
 * 类说明: 系统操作文件相关业务不正确时，抛出异常
 * 更新记录：
 */
public class FileBusinessException extends BaseException implements Serializable{

    private static final long serialVersionUID = 1338881600551967340L;

    public FileBusinessException(String message) {
        super(message);
    }
}
