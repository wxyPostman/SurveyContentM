package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Townshipvideo;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.TownshipvideoService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class TownshipvideoController {
    @Autowired
    private TownshipvideoService townshipvideoService;


    //返回所有数据
    @RequestMapping("getTownshipvideo")
    @ResponseBody
    public JsonResult<Townshipvideo> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Townshipvideo> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = townshipvideoService.findAll(newpage, newlimit, startTime);
            count = townshipvideoService.countNum(startTime);
        }else{
            list = townshipvideoService.findAll(newpage,newlimit,years);
            count = townshipvideoService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("TownshipvideoGetByid")
    @ResponseBody
    public Townshipvideo findAll(Integer id) {
        Townshipvideo townshipvideo = townshipvideoService.findById(id);
        return townshipvideo;
    }

    //返回单个数据
    @RequestMapping("updateTownshipvideo")
    @ResponseBody
    public Result<Townshipvideo> update(Townshipvideo townshipvideo) {
        return   ResultUtil.success(townshipvideoService.update(townshipvideo));
    }

    //返回单个数据
    @RequestMapping("addTownshipvideo")
    @ResponseBody
    public Result<Townshipvideo> addOrganization(Townshipvideo townshipvideo) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        townshipvideo.setAddyear(year.toString());
        return   ResultUtil.success(townshipvideoService.save(townshipvideo));
    }

    //返回单个数据
    @RequestMapping("deleteTownshipvideo")
    @ResponseBody
    public Result<Townshipvideo> deleteOrganization(Integer id) {
        return   ResultUtil.success(townshipvideoService.delete(id));
    }
}
