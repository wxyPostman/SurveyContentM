package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Specifications;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.SpecificationsService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class SpecificationsController {
    @Autowired
    private SpecificationsService specificationsService;

    //返回所有数据
    @RequestMapping("specificationsGetAll")
    @ResponseBody
    public JsonResult<Specifications> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Specifications> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = specificationsService.findAll(newpage, newlimit, startTime);
            count = specificationsService.countNum(startTime);
        }else{
            list = specificationsService.findAll(newpage,newlimit,years);
            count = specificationsService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("specificationsGetByid")
    @ResponseBody
    public Specifications findAll(Integer id) {
        Specifications systemPlan = specificationsService.findById(id);
        return systemPlan;
    }

    //返回单个数据
    @RequestMapping("updateSpecifications")
    @ResponseBody
    public Result<Specifications> update(Specifications specifications) {
        return   ResultUtil.success(specificationsService.update(specifications));
    }

    //返回单个数据
    @RequestMapping("addSpecifications")
    @ResponseBody
    public Result<Specifications> addOrganization(Specifications specifications) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        specifications.setAddyear(year.toString());
        return   ResultUtil.success(specificationsService.save(specifications));
    }

    //返回单个数据
    @RequestMapping("deleteSpecifications")
    @ResponseBody
    public Result<Specifications> deleteOrganization(Integer id) {
        return   ResultUtil.success(specificationsService.delete(id));
    }
}
