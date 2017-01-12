package cn.com.showings.pojo.exception;

import java.io.Serializable;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/22
 * 类说明:
 * 更新记录：
 */
public class TargetNotFoundException extends BaseException implements Serializable {

    private static final long serialVersionUID = -8614082664816299686L;

    public TargetNotFoundException(String message) {
        super(message);
    }
}
