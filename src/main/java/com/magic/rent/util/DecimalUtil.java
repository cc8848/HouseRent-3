package com.magic.rent.util;

import java.text.DecimalFormat;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/28
 * 类说明:
 * 更新记录：
 */
public class DecimalUtil {

    public static String formateMoney(double money) {

        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern("##,###.00");
        return decimalFormat.format(money);
    }
}
