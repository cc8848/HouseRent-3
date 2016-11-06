package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.RentMode;
import com.magic.rent.service.IRentModeService;
import com.magic.rent.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wu on 2016/11/4.
 */
@Controller
@RequestMapping("/rentMode")
public class RentModeController extends BaseController {

    @Autowired
    private IRentModeService iRentModeService;

    @ResponseBody
    @RequestMapping("/getRentModes")
    public JsonResult getRentModeByHouseID(HttpServletRequest request) throws Exception {
        if (StringUtils.isEmpty(request.getParameter("houseID")))
            throw new ParameterException(messageSourceAccessor.getMessage("RentModeService.houseIDNotNull", "【房屋编号】不能为空!"));

        int houseID = Integer.parseInt(request.getParameter("houseID"));

        List<RentMode> rentModeList = iRentModeService.selectRentModesByHouseID(houseID);

        return JsonResult.success(rentModeList);
    }

}
