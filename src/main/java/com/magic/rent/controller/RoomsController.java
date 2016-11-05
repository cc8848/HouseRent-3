package com.magic.rent.controller;

import com.magic.rent.controller.base.BaseController;
import com.magic.rent.exception.custom.ParameterException;
import com.magic.rent.pojo.Rooms;
import com.magic.rent.service.IRoomsService;
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
@RequestMapping("/rooms")
public class RoomsController extends BaseController {

    @Autowired
    private IRoomsService iRoomsService;

    @ResponseBody
    @RequestMapping("/getRooms")
    public JsonResult getRoomsByHouseID(HttpServletRequest request) throws Exception {
        if (StringUtils.isEmpty(request.getParameter("houseID")))
            throw new ParameterException(messageSourceAccessor.getMessage("RoomsService.houseIDNotNull", "房屋编号不能为空！"));
        int houseID = Integer.parseInt(request.getParameter("houseID"));
        List<Rooms> roomsList = iRoomsService.selectRoomsByHouseID(houseID);
        return JsonResult.success(roomsList);
    }
}
