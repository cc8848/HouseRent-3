package com.magic.rent.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/25
 * 类说明:
 * 更新记录：
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取项目根目录
     *
     * @return 根目录
     */
    public static String getWebRootPath() {

        return System.getProperty("web.root");
    }

    /**
     * 获取VR目录
     *
     * @param houseID
     * @return
     */
    public static String getVRFilePath(int houseID) {
        return getWebRootPath() + "images/house/vtour/" + houseID + "/";
    }

    public static String creatNewFileNameWithDate(String oldFileName) {
        StringBuffer newFileName = new StringBuffer("No");
        String[] names = oldFileName.split(".");
        newFileName.append(DateFormatUtil.formatToNo(new Date())).append("-").append(names[0]);

        String newName = "[No" + DateFormatUtil.FormatToYMD(new Date()) + "]" + names[0];

        return newFileName.toString();
    }
}
