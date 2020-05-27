package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Projectinvest;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.ProjectinvestService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class ProjectinvestController {

    @Autowired
    private ProjectinvestService projectinvestService;


    //返回所有数据
    @RequestMapping("getProjectinvest")
    @ResponseBody
    public JsonResult<Projectinvest> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Projectinvest> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = projectinvestService.findAll(newpage, newlimit, startTime);
            count = projectinvestService.countNum(startTime);
        }else{
            list = projectinvestService.findAll(newpage,newlimit,years);
            count = projectinvestService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("ProjectinvestGetByid")
    @ResponseBody
    public Projectinvest findAll(Integer id) {
        Projectinvest visualnet = projectinvestService.findById(id);
        return visualnet;
    }

    //返回单个数据
    @RequestMapping("updateProjectinvest")
    @ResponseBody
    public Result<Projectinvest> update(Projectinvest projectinvest) {
        return   ResultUtil.success(projectinvestService.update(projectinvest));
    }

    //返回单个数据
    @RequestMapping("addProjectinvest")
    @ResponseBody
    public Result<Projectinvest> addOrganization(Projectinvest projectinvest) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        projectinvest.setAddyear(year.toString());
        return   ResultUtil.success(projectinvestService.save(projectinvest));
    }

    //返回单个数据
    @RequestMapping("deleteProjectinvest")
    @ResponseBody
    public Result<Projectinvest> deleteOrganization(Integer id) {
        return   ResultUtil.success(projectinvestService.delete(id));
    }
}
