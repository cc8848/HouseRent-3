package cn.com.showings.tools;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/15
 * 类说明: 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法
 * 更新记录：
 */

import cn.com.showings.pojo.exception.FileBusinessException;
import cn.com.showings.pojo.exception.TargetNotFoundException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class CompressTools {
    private File file; // 文件对象
    private Image image;
    private String outputDir; // 输出图路径
    private String outputFileName; // 输出图文件名
    private int outputWidth; // 输出图片宽
    private int outputHeight; // 输出图片高
    private boolean proportion = true; // 是否等比缩放标记(默认为等比缩放)

    private static Logger logger = LoggerFactory.getLogger(CompressTools.class);

    public CompressTools(File file) throws Exception {
        //判断文件是否存在，并且赋予初始值
        if (file.exists()) {
            this.file = file;
            this.outputDir = file.getPath();
            this.outputFileName = file.getName();
            this.image = ImageIO.read(file);
            if (image.getWidth(null) == -1) {
                throw new FileBusinessException("文件信息读取失败！");
            } else {
                this.outputWidth = image.getWidth(null);
                this.outputHeight = image.getHeight(null);
            }
        } else {
            throw new TargetNotFoundException("目标文件不存在");
        }
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public int getOutputWidth() {
        return outputWidth;
    }

    public void setOutputWidth(int outputWidth) {
        this.outputWidth = outputWidth;
    }

    public int getOutputHeight() {
        return outputHeight;
    }

    public void setOutputHeight(int outputHeight) {
        this.outputHeight = outputHeight;
    }

    public boolean isProportion() {
        return proportion;
    }

    public void setProportion(boolean proportion) {
        this.proportion = proportion;
    }

    /**
     * 获取图片大小，单位KB
     *
     * @return
     */
    private String getPicSize() {
        return file.length() / 1024 + "KB";
    }


    /**
     * 简单压缩方法
     *
     * @param outputHeight 输出高度
     * @param outputWidth  输出宽度
     * @param proportion   是否等比压缩
     * @return
     * @throws Exception
     */
    public boolean simpleCompress(int outputHeight, int outputWidth, boolean proportion) throws Exception {
        setOutputHeight(outputHeight);
        setOutputWidth(outputWidth);
        setProportion(proportion);
        return startCompress();
    }


    /**
     * 图片压缩处理
     *
     * @return
     * @throws Exception
     */
    public boolean startCompress() throws Exception {
        int newWidth;
        int newHeight;
        // 判断是否是等比缩放
        if (this.proportion) {
            // 为等比缩放计算输出的图片宽度及高度
            double rate1 = ((double) image.getWidth(null)) / (double) outputWidth + 0.1;
            double rate2 = ((double) image.getHeight(null)) / (double) outputHeight + 0.1;
            // 根据缩放比率大的进行缩放控制
            double rate = rate1 > rate2 ? rate1 : rate2;
            newWidth = (int) (((double) image.getWidth(null)) / rate);
            newHeight = (int) (((double) image.getHeight(null)) / rate);
        } else {
            newWidth = outputWidth; // 输出的图片宽度
            newHeight = outputHeight; // 输出的图片高度
        }
        long start = System.currentTimeMillis();

        BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        //Image.SCALE_SMOOTH的缩略算法,生成缩略图片的平滑度的优先级比速度高,生成的图片质量比较好,但速度慢
        tag.getGraphics().drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
        FileOutputStream out = new FileOutputStream(outputDir);
        // JPEGImageEncoder可适用于其他图片类型的转换
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(tag);
        out.close();

        long time = System.currentTimeMillis() - start;
        logger.info("[输出路径]：" + outputDir + "\t[图片名称]：" + outputFileName + "\t[压缩前大小]：" + getPicSize() + "\t[耗时]：" + time + "毫秒");

        return true;
    }

}