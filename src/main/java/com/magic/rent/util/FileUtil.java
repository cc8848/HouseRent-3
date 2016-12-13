package com.magic.rent.util;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.pojo.ViewMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Date;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/25
 * 类说明:
 * 更新记录：
 */
public class FileUtil {

    public static final int IMG = 1;


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
     * 获取头像目录，若不存在则直接创建一个
     *
     * @param userID
     * @return
     */
    public static String getPortraitPath(int userID) {
        String realPath = getWebRootPath() + "img/portrait/" + userID + "/";
        File file = new File(realPath);
        //判断文件夹是否存在，不存在则创建一个
        if (!file.exists() || !file.isDirectory()) {
            if (!file.mkdirs()) {
                throw new BusinessException("创建头像文件夹失败！");
            }
        }
        return realPath;
    }

    /**
     * 重命名头像文件
     *
     * @param fileName
     * @return
     */
    public static String getPortraitFileName(String fileName) {
        // 获取文件后缀
        String extension = fileName.substring(fileName.lastIndexOf("."));
        return "portrait" + extension.toLowerCase();
    }

    /**
     * 将文件地址转成链接地址
     *
     * @param filePath
     * @param fileType
     * @return
     */
    public static String filePathToHref(String filePath, int fileType) {
        String href = "";
        if (null != filePath && !filePath.equals("")) {
            switch (fileType) {
                case IMG:
                    if (filePath.contains("/img/")) {
                        int index = filePath.indexOf("/img/");
                        href = filePath.substring(index);
                    } else {
                        href = "";
                    }
                    return href;
            }
        }
        return href;
    }

    /**
     * @param obj
     * @return
     */
    public static ArrayList<File> getListFiles(Object obj) {
        File directory = null;
        if (obj instanceof File) {
            directory = (File) obj;
        } else {
            directory = new File(obj.toString());
        }
        ArrayList<File> files = new ArrayList<File>();
        if (directory.isFile()) {
            files.add(directory);
            return files;
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            assert fileArr != null;
            for (File fileOne : fileArr) {
                files.addAll(getListFiles(fileOne));
            }
        }
        return files;
    }
}