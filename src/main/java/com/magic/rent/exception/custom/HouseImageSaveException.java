package com.magic.rent.exception.custom;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/24
 * 类说明:
 * 更新记录：
 */
public class HouseImageSaveException extends BaseException {

    private Object data;

    public HouseImageSaveException(String message) {
        super(message);
    }

    public HouseImageSaveException(String message, Object data) {
        super(message);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
