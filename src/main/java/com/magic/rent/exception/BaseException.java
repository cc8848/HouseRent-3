package com.magic.rent.exception;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/30
 * 类说明:
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -4203517384247373855L;

    protected BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
