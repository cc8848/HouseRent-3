package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.SelectPoJo;
import com.magic.rent.service.IAddressService;
import com.magic.rent.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/address")
public class AddressController extends BaseController {

    @Autowired
    private IAddressService iAddressService;

    @ResponseBody
    @RequestMapping("/all")
    public JsonResult getAll() throws Exception {
        return JsonResult.success(iAddressService.getAllAddress());
    }


    @ResponseBody
    @RequestMapping("/getAllProvince")
    public JsonResult getAllProvince() throws Exception {

        List<SelectPoJo> selectPoJoList = iAddressService.getAllProvince();

        return JsonResult.success("", selectPoJoList);
    }


    @ResponseBody
    @RequestMapping("/getCityByProvince")
    public JsonResult getCityByProvince(HttpServletRequest request) throws Exception {

        String provinceID = request.getParameter("provinceID");

        if (StringUtils.isEmpty(provinceID))
            throw new ParameterException(messageSourceAccessor.getMessage("provinceNameNotFound", "省份ID缺失!"));

        List<SelectPoJo> selectPoJoList = iAddressService.getCityByProvinceID(Integer.valueOf(provinceID));

        return JsonResult.success("", selectPoJoList);
    }


    @ResponseBody
    @RequestMapping("/getAllCity")
    public JsonResult getAllCity() throws Exception {

        List<SelectPoJo> selectPoJoList = iAddressService.getAllCity();

        return JsonResult.success("", selectPoJoList);
    }

    @ResponseBody
    @RequestMapping("/getAreaByCity")
    public JsonResult getAreaByCity(HttpServletRequest request) throws Exception {
        String cityID = request.getParameter("cityID");

        if (StringUtils.isEmpty(cityID))
            throw new ParameterException(messageSourceAccessor.getMessage("provinceNameNotFound", "城市ID缺失!"));

        List<SelectPoJo> selectPoJoList = iAddressService.getAreaByCityID(Integer.valueOf(cityID));

        return JsonResult.success("", selectPoJoList);
    }


}
