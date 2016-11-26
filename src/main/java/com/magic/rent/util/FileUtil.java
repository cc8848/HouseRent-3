package com.magic.rent.util;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.pojo.ViewMode;
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
    public static String getFilePath(int houseID, int viewMode) {
        switch (viewMode) {
            case ViewMode.VRMode:
                return getWebRootPath() + "images/house/vtour/" + houseID + "/";
            case ViewMode.thumbnailMode:
                return getWebRootPath() + "images/house/thumbnail/" + houseID + "/";
            default:
                throw new BusinessException("为找到符合的浏览模式！");
        }
    }

    /**
     * 根据房屋ID创建新文件名
     *
     * @param oldFileName
     * @param houseID
     * @return
     * @throws Exception
     */
    public static String getNewFileNameByHouseID(String oldFileName, int houseID) throws Exception {
        if (oldFileName.contains(".")) {
            String prefix = oldFileName.substring(oldFileName.lastIndexOf(".") + 1);
            return new StringBuffer("ID").append(houseID).append("-").append(DateFormatUtil.formatToNo(new Date())).append(".").append(prefix).toString();
        } else {
            throw new BusinessException("文件名不符合规范，没有'.'作为后缀的分割符！");
        }
    }
}