package com.magic.rent.util;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.pojo.ViewMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
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
    public static String filePathToSRC(String filePath, int fileType) {
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
     * 获取指定文件或文件路径下的所有文件清单
     *
     * @param obj
     * @return
     */
    public static ArrayList<File> getListFiles(Object obj) {
        File directory;
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
            if (null != fileArr && fileArr.length != 0) {
                for (File fileOne : fileArr) {
                    files.addAll(getListFiles(fileOne));
                }
            }
        }

        return files;
    }


    /**
     * 截取图片
     *
     * @param srcImageFile 原图片地址
     * @param x            截取时的x坐标
     * @param y            截取时的y坐标
     * @param desWidth     截取的宽度
     * @param desHeight    截取的高度
     */
    public static void imgCut(String srcImageFile, int x, int y, int desWidth,
                              int desHeight) {
        try {
            Image img;
            ImageFilter cropFilter;
            BufferedImage bi = ImageIO.read(new File(srcImageFile + "_src.jpg"));
            int srcWidth = bi.getWidth();
            int srcHeight = bi.getHeight();
            if (srcWidth >= desWidth && srcHeight >= desHeight) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                cropFilter = new CropImageFilter(x, y, desWidth, desHeight);
                img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(desWidth, desHeight,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();
                //输出文件
                ImageIO.write(tag, "JPEG", new File(srcImageFile + "_cut.jpg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}