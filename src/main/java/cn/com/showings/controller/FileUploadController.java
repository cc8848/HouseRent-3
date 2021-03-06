package cn.com.showings.controller;

import cn.com.showings.controller.base.BaseController;
import cn.com.showings.pojo.exception.BusinessException;
import cn.com.showings.pojo.HouseImage;
import cn.com.showings.pojo.SysUsers;
import cn.com.showings.service.IHandHouseService;
import cn.com.showings.service.IUserService;
import cn.com.showings.tools.FileTools;
import cn.com.showings.pojo.JsonResult;
import cn.com.showings.tools.HttpTools;
import cn.com.showings.tools.MyStringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private IUserService iUserService;

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

        List<MultipartFile> multipartFileList = FileTools.getFilesFromRequest(request, PORTRAIT_ALLOW_SUFFIX);

        SysUsers sysUsers = HttpTools.getSessionUser(request);

        MultipartFile multipartFile = multipartFileList.get(0);

        String src = iUserService.savePortrait(multipartFile, sysUsers.getUserId(), x, y, w, h, sw, sh);

        return JsonResult.success(src);
    }

    @ResponseBody
    @RequestMapping(value = "/house", method = {RequestMethod.POST})
    public JsonResult houseUpload(HttpServletRequest request, @RequestParam("thumbnail") MultipartFile file) throws Exception {

        if (FileTools.checkSuffix(file.getOriginalFilename(), HOUSE_ALLOW_SUFFIX)) {
            SysUsers sysUsers = HttpTools.getSessionUser(request);

            HouseImage houseImage = iHandHouseService.saveHousePictures(file, sysUsers.getUserId());

            return JsonResult.success(houseImage);
        } else {
            throw new BusinessException("文件后缀名不符！");
        }
    }
}
