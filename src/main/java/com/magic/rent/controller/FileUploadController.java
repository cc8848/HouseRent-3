package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.service.IHouseService;
import com.magic.rent.util.FileUtil;
import com.magic.rent.util.JsonResult;
import com.magic.rent.util.MyStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    @Autowired
    private IHouseService iHouseService;

    @ResponseBody
    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public JsonResult upload(HttpServletRequest request) throws Exception {

        return null;
    }
}
