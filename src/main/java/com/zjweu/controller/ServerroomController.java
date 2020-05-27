package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Serverroom;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.ServerroomService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class ServerroomController {
    @Autowired
    private ServerroomService serverroomService;


    //返回所有数据
    @RequestMapping("getServerroom")
    @ResponseBody
    public JsonResult<Serverroom> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Serverroom> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = serverroomService.findAll(newpage, newlimit, startTime);
            count = serverroomService.countNum(startTime);
        }else{
            list = serverroomService.findAll(newpage,newlimit,years);
            count = serverroomService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    @RequestMapping("ServerroomGetByid")
    @ResponseBody
    public Serverroom findAll(Integer id) {
        Serverroom serverroom = serverroomService.findById(id);
        return serverroom;
    }

    @RequestMapping("updateServerroom")
    @ResponseBody
    public Result<Serverroom> update(Serverroom serverroom) {
        return   ResultUtil.success(serverroomService.update(serverroom));
    }

    @RequestMapping("addServerroom")
    @ResponseBody
    public Result<Serverroom> addOrganization(Serverroom serverroom) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        serverroom.setAddyear(year.toString());
        return   ResultUtil.success(serverroomService.save(serverroom));
    }

    @RequestMapping("deleteServerroom")
    @ResponseBody
    public Result<Serverroom> deleteOrganization(Integer id) {
        return   ResultUtil.success(serverroomService.delete(id));
    }
}
