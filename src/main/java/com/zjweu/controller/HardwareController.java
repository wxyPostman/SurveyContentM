package com.zjweu.controller;

import com.zjweu.dao.HardwareDAO;
import com.zjweu.domain.Result;
import com.zjweu.entity.Hardware;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.HardwareService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class HardwareController {
    @Autowired
    private HardwareService hardwareService;


    //返回所有数据
    @RequestMapping("getHardware")
    @ResponseBody
    public JsonResult<Hardware> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Hardware> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = hardwareService.findAll(newpage, newlimit, startTime);
            count = hardwareService.countNum(startTime);
        }else{
            list = hardwareService.findAll(newpage,newlimit,years);
            count = hardwareService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    @RequestMapping("HardwareGetByid")
    @ResponseBody
    public Hardware findAll(Integer id) {
        Hardware hardware = hardwareService.findById(id);
        return hardware;
    }

    @RequestMapping("updateHardware")
    @ResponseBody
    public Result<Hardware> update(Hardware hardware) {
        return   ResultUtil.success(hardwareService.update(hardware));
    }

    @RequestMapping("addHardware")
    @ResponseBody
    public Result<Hardware> addOrganization(Hardware hardware) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        hardware.setAddyear(year.toString());
        return   ResultUtil.success(hardwareService.save(hardware));
    }

    @RequestMapping("deleteHardware")
    @ResponseBody
    public Result<Hardware> deleteOrganization(Integer id) {
        return   ResultUtil.success(hardwareService.delete(id));
    }
}
