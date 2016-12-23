package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.pojo.HouseImage;
import com.magic.rent.pojo.SysUsers;
import com.magic.rent.service.IHandHouseService;
import com.magic.rent.tools.CompressTools;
import com.magic.rent.tools.FileTools;
import com.magic.rent.pojo.JsonResult;
import com.magic.rent.tools.HttpTools;
import com.magic.rent.tools.MyStringTools;
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
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/25
 * 类说明:
 * 更新记录：
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController extends BaseController {

    private static final String[] PORTRAIT_ALLOW_SUFFIX = {".jpg", ".JPG"};

    private static final String[] HOUSE_ALLOW_SUFFIX = {".jpg", ".JPG"};

    @Autowired
    private IHandHouseService iHandHouseService;

    @ResponseBody
    @RequestMapping(value = "/portrait", method = {RequestMethod.POST})
    public JsonResult portraitUpload(HttpServletRequest request) throws Exception {
        Integer x = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("x"), "图片截取异常:X！"));
        Integer y = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("y"), "图片截取异常:Y！"));
        Integer w = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("w"), "图片截取异常:W！"));
        Integer h = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("h"), "图片截取异常:H！"));
        String scaleWidthString = MyStringTools.checkParameter(request.getParameter("sw"), "图片截取异常：SW！");
        int swIndex = scaleWidthString.indexOf("px");
        Integer sw = Integer.parseInt(scaleWidthString.substring(0, swIndex));
        String scaleHeightString = MyStringTools.checkParameter(request.getParameter("sh"), "图片截取异常：SH！");
        int shIndex = scaleHeightString.indexOf("px");
        Integer sh = Integer.parseInt(scaleHeightString.substring(0, shIndex));

        //获取用户ID用于指向对应文件夹
        SysUsers sysUsers = HttpTools.getSessionUser(request);
        int userID = sysUsers.getUserId();
        //获取文件路径
        String filePath = FileTools.getPortraitPath(userID);

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        String path;
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iterator = multiRequest.getFileNames();
            while (iterator.hasNext()) {
                //一次遍历所有文件
                MultipartFile multipartFile = multiRequest.getFile(iterator.next().toString());
                if (null != multipartFile) {
                    if (!FileTools.checkSuffix(multipartFile.getOriginalFilename(), PORTRAIT_ALLOW_SUFFIX)) {
                        throw new BusinessException("文件类型不符合要求！");
                    }
                    path = filePath + FileTools.getPortraitFileName(multipartFile.getOriginalFilename());
                    //存入硬盘
                    multipartFile.transferTo(new File(path));
                    //图片截取
                    if (FileTools.imgCut(path, x, y, w, h, sw, sh)) {
                        CompressTools compressTools = new CompressTools(new File(path));
                        if (compressTools.simpleCompress(300, 300, true)) {
                            return JsonResult.success(FileTools.filePathToSRC(path, FileTools.IMG));
                        } else {
                            return JsonResult.error("图片压缩失败！请重新上传！");
                        }
                    } else {
                        return JsonResult.error("图片截取失败！请重新上传！");
                    }
                }
            }
        }
        return JsonResult.error("图片获取失败！请重新上传！");
    }

    @ResponseBody
    @RequestMapping(value = "/house", method = {RequestMethod.POST})
    public JsonResult houseUpload(HttpServletRequest request) throws Exception {

        List<MultipartFile> multipartFileList = FileTools.getFilesFromRequest(request, HOUSE_ALLOW_SUFFIX);

        SysUsers sysUsers = HttpTools.getSessionUser(request);

        List<HouseImage> houseImageList = iHandHouseService.safeHousePictures(multipartFileList, sysUsers.getUserId());

        return JsonResult.success(houseImageList);
    }
}
