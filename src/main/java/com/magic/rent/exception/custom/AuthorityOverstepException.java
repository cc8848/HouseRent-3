package com.magic.rent.exception.custom;

import java.io.Serializable;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/22
 * 类说明: 当用户的操作超越权限时，抛出异常
 * 更新记录：
 */
public class AuthorityOverstepException extends BaseException implements Serializable {

    private static final long serialVersionUID = 8260394139503044935L;

    public AuthorityOverstepException(String message) {
        super(message);
    }
}
