package com.magic.rent.util;

import com.magic.rent.controller.LoginAuthenticationController;
import com.magic.rent.exception.custom.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Iterator;

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


    /**
     * 保存VR全景图片
     *
     * @param request
     * @param houseID
     * @throws Exception
     */
    public static void saveVRFile(HttpServletRequest request, int houseID) throws Exception {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iterator = multiRequest.getFileNames();
            while (iterator.hasNext()) {
                //记录上传过程起始时的时间，用来计算上传时间
                String newFileName;
                long startTime = System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iterator.next());
                if (null != file && !file.isEmpty()) {
                    //取得当前上传文件的文件名称
                    String uploadFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (!StringUtils.isEmpty(uploadFileName.trim())) {
                        //重命名上传后的文件名
                        newFileName = file.getOriginalFilename() + DateFormat.FormatToYMD(new Date());
                        //定义上传路径
                        String path = getVRFilePath(houseID) + newFileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                        //记录上传该文件后的时间
                        long endTime = System.currentTimeMillis();
                        logger.info("【上传耗时：" + (endTime - startTime) + "】【上传文件名：" + newFileName + "】【文件大小：" + file.getSize() + "】");
                    } else {
                        throw new BusinessException("上传文件名为空或仅为空格！请重新上传！");
                    }
                } else {
                    throw new BusinessException("VR全景图文件损坏或文件内容为空,请重新上传！");
                }
            }
        } else {
            throw new BusinessException("VR全景图未上传！");
        }
    }
}
