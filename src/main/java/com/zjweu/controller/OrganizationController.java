package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Organization;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.OrganizationService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    //返回所有数据
    @RequestMapping("zjweu/getjigou")
    @ResponseBody
    public JsonResult<Organization> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Organization> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
           list = organizationService.findAll(newpage, newlimit, startTime);
           count = organizationService.countNum(startTime);
        }else{
            list = organizationService.findAll(newpage,newlimit,years);
            count = organizationService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("zjweu/getById")
    @ResponseBody
    public Organization findAll(Integer id) {
        Organization organization = organizationService.findById(id);
        return organization;
    }

    //返回单个数据
    @RequestMapping("updateOrganization")
    @ResponseBody
    public Result<Organization> update(Organization organization) {
        if(organization.getFunds()==null){
            organization.setFunds(0);
        }
        return   ResultUtil.success(organizationService.update(organization));
    }

    //返回单个数据
    @RequestMapping("addOrganization")
    @ResponseBody
    public Result<Organization> addOrganization(Organization organization) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        organization.setAddyear(year.toString());
        if(organization.getFunds()==null){
            organization.setFunds(0);
        }
        return   ResultUtil.success(organizationService.save(organization));
    }

    //返回单个数据
    @RequestMapping("deleteOrganization")
    @ResponseBody
    public Result<Organization> deleteOrganization(Integer id) {
        return   ResultUtil.success(organizationService.delete(id));
    }

}
