package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.service.ISysStoreService;
import com.magic.rent.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wu on 2016/11/19.
 */
@Controller
@RequestMapping("/store")
public class SysStoreController extends BaseController {
    @Autowired
    private ISysStoreService iSysStoreService;

    @RequestMapping("/getNum")
    @ResponseBody
    public JsonResult getNum(HttpServletRequest request) throws Exception {

        if (StringUtils.isEmpty(request.getParameter("areaID"))) {
            throw new ParameterException(messageSourceAccessor.getMessage("SysStoreService.areaNameNotNUll", "地区名称不能为空！"));
        }

        String areaID = request.getParameter("areaID");

        return JsonResult.success(iSysStoreService.selectStoreNumByAreaID(areaID));
    }
}
