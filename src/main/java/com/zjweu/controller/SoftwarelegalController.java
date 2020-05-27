package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Softwarelegal;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.SoftwarelegalService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class SoftwarelegalController {
    @Autowired
    private SoftwarelegalService softwarelegalService;

    //返回所有数据
    @RequestMapping("softwarelegalGetAll")
    @ResponseBody
    public JsonResult<Softwarelegal> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Softwarelegal> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = softwarelegalService.findAll(newpage, newlimit, startTime);
            count = softwarelegalService.countNum(startTime);
        }else{
            list = softwarelegalService.findAll(newpage,newlimit,years);
            count = softwarelegalService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("softwarelegalGetByid")
    @ResponseBody
    public Softwarelegal findAll(Integer id) {
        Softwarelegal softwarelegal = softwarelegalService.findById(id);
        return softwarelegal;
    }

    //返回单个数据
    @RequestMapping("updateSoftwarelegal")
    @ResponseBody
    public Result<Softwarelegal> update(Softwarelegal softwarelegal) {
        return   ResultUtil.success(softwarelegalService.update(softwarelegal));
    }

    //返回单个数据
    @RequestMapping("addSoftwarelegal")
    @ResponseBody
    public Result<Softwarelegal> addOrganization(Softwarelegal softwarelegal) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        softwarelegal.setAddyear(year.toString());
        return   ResultUtil.success(softwarelegalService.save(softwarelegal));
    }

    //返回单个数据
    @RequestMapping("deleteSoftwarelegal")
    @ResponseBody
    public Result<Softwarelegal> deleteOrganization(Integer id) {
        return   ResultUtil.success(softwarelegalService.delete(id));
    }

}
