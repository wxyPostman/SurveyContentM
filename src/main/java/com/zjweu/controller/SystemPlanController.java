package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Organization;
import com.zjweu.entity.SystemPlan;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.OrganizationService;
import com.zjweu.service.SystemPlanService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

@Controller
public class SystemPlanController {
    @Autowired
    private SystemPlanService systemPlanService;

    //返回所有数据
    @RequestMapping("systemplanGetAll")
    @ResponseBody
    public JsonResult<SystemPlan> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<SystemPlan> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = systemPlanService.findAll(newpage, newlimit, startTime);
            count = systemPlanService.countNum(startTime);
        }else{
            list = systemPlanService.findAll(newpage,newlimit,years);
            count = systemPlanService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("systemplanGetByid")
    @ResponseBody
    public SystemPlan findAll(Integer id) {
        SystemPlan systemPlan = systemPlanService.findById(id);
        return systemPlan;
    }

    //返回单个数据
    @RequestMapping("updateSystemPlan")
    @ResponseBody
    public Result<SystemPlan> update(SystemPlan systemPlan) {
        return   ResultUtil.success(systemPlanService.update(systemPlan));
    }

    //返回单个数据
    @RequestMapping("addSystemPlan")
    @ResponseBody
    public Result<SystemPlan> addOrganization(SystemPlan systemPlan) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        systemPlan.setAddyear(year.toString());
        return   ResultUtil.success(systemPlanService.save(systemPlan));
    }

    //返回单个数据
    @RequestMapping("deleteSystemPlan")
    @ResponseBody
    public Result<Organization> deleteOrganization(Integer id) {
        return   ResultUtil.success(systemPlanService.delete(id));
    }

}

