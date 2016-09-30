package com.magic.rent.exception.custom;

import com.magic.rent.exception.BaseException;
import com.magic.rent.util.Log;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/29
 * 类说明:
 */
public class BusinessException extends BaseException {

    public BusinessException(String message, Object trade) {
        super(message, trade);
        Log.error(trade, "业务逻辑异常", message, this);
    }
}
