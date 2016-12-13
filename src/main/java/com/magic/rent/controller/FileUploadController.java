package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IHouseService;
import com.magic.rent.util.FileUtil;
import com.magic.rent.pojo.JsonResult;
import com.magic.rent.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/25
 * 类说明:
 * 更新记录：
 */
@Controller
@RequestMapping("/file")
public class FileUploadController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    @ResponseBody
    @RequestMapping(value = "/portrait", method = {RequestMethod.POST})
    public JsonResult upload(HttpServletRequest request) throws Exception {
        //获取用户ID用于指向对应文件夹
        SysUsers sysUsers = HttpUtil.getSessionUser(request);
        int userID = sysUsers.getUserId();
        //获取文件路径
        String filePath = FileUtil.getPortraitPath(userID);

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        String path = "";
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iterator = multiRequest.getFileNames();
            while (iterator.hasNext()) {
                //一次遍历所有文件
                MultipartFile multipartFile = multiRequest.getFile(iterator.next().toString());
                if (multipartFile != null) {
                    path = filePath + FileUtil.getPortraitFileName(multipartFile.getOriginalFilename());
                    //存入硬盘
                    multipartFile.transferTo(new File(path));
                }
            }
        }
        return JsonResult.success(FileUtil.filePathToHref(path, FileUtil.IMG)).setMessage("头像上传成功！");
    }
}
