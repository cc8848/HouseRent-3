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
    public static String getVRFilePath(String houseID) {
        return getWebRootPath() + "images/house/vtour/" + houseID + "/";
    }

    /**
     * 根据房屋ID创建新文件名
     *
     * @param oldFileName
     * @param houseID
     * @return
     * @throws Exception
     */
    public static String getNewFileNameByHouseID(String oldFileName, String houseID) throws Exception {
        String[] names = oldFileName.split(".");
        return new StringBuffer("ID").append(houseID).append("-").append(DateFormatUtil.formatToNo(new Date())).append(".").append(names[1]).toString();
    }
}