package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Cloudapp;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.CloudappService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class CloudappController {

    @Autowired
    private CloudappService cloudappService;


    //返回所有数据
    @RequestMapping("getCloudapp")
    @ResponseBody
    public JsonResult<Cloudapp> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Cloudapp> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = cloudappService.findAll(newpage, newlimit, startTime);
            count = cloudappService.countNum(startTime);
        }else{
            list = cloudappService.findAll(newpage,newlimit,years);
            count = cloudappService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("CloudappGetByid")
    @ResponseBody
    public Cloudapp findAll(Integer id) {
        Cloudapp cloudapp = cloudappService.findById(id);
        return cloudapp;
    }

    //返回单个数据
    @RequestMapping("updateCloudapp")
    @ResponseBody
    public Result<Cloudapp> update(Cloudapp cloudapp) {
        return   ResultUtil.success(cloudappService.update(cloudapp));
    }

    //返回单个数据
    @RequestMapping("addCloudapp")
    @ResponseBody
    public Result<Cloudapp> addOrganization(Cloudapp cloudapp) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        cloudapp.setAddyear(year.toString());
        return   ResultUtil.success(cloudappService.save(cloudapp));
    }

    //返回单个数据
    @RequestMapping("deleteCloudapp")
    @ResponseBody
    public Result<Cloudapp> deleteOrganization(Integer id) {
        return   ResultUtil.success(cloudappService.delete(id));
    }
}
