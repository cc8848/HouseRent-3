package com.magic.rent.util;

import org.apache.commons.logging.LogFactory;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/23
 * 类说明:
 */
public class Log {

    public static void info(Class clazz,String tittle, String text) {
        org.apache.commons.logging.Log logger = LogFactory.getLog(clazz);
        String infoStart = "\n————————————————————————————————————————[Info Start]——\n";
        String infoEnd = "信息: ————————————————————————————————————————[Info   End]——\n";
        StringBuffer stringBuffer = new StringBuffer(infoStart);
        stringBuffer.append("标题:" + tittle + "\n内容:")
                .append(text + "\n")
                .append(infoEnd);
        logger.info(stringBuffer.toString());
    }

    public static void error(Class clazz,String tittle, String text) {
        org.apache.commons.logging.Log logger = LogFactory.getLog(clazz);
        String infoStart = "\n————————————————————————————————————————[Info Start]——\n";
        String infoEnd = "信息: ————————————————————————————————————————[Info   End]——\n";
        StringBuffer stringBuffer = new StringBuffer(infoStart);
        stringBuffer.append("标题:" + tittle + "\n内容:")
                .append(text + "\n")
                .append(infoEnd);
        logger.error(stringBuffer.toString());
    }

}
