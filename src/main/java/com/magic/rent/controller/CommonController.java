package com.magic.rent.controller;

import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.Province;
import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.service.ICommonService;
import com.magic.rent.service.impl.CommonServiceImpl;
import com.magic.rent.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/10/9
 * 类说明:
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private ICommonService iCommonService;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @ResponseBody
    @RequestMapping("/getCityByProvince")
    public JsonResult getCityByProvince(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String provinceName = request.getParameter("provinceName");

        if (StringUtils.isEmpty(provinceName))
            throw new ParameterException(messageSourceAccessor.getMessage("provinceNameNotFound", "省份名缺失!"));

        Province province = new Province();
        province.setProvincename(provinceName);

        List<SelectPoJo> selectPoJoList = iCommonService.getCityByProvinceName(province);

        return JsonResult.success("", selectPoJoList);
    }


    @ResponseBody
    @RequestMapping("/getAllCity")
    public JsonResult getAllCity() throws Exception {

        List<SelectPoJo> selectPoJoList = iCommonService.getAllCity();

        return JsonResult.success("", selectPoJoList);
    }
}
