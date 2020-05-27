package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Traditionalconsult;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.TraditionalconsultService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class TraditionalconsultController {

    @Autowired
    private TraditionalconsultService traditionalconsultService;


    //返回所有数据
    @RequestMapping("getTraditionalconsult")
    @ResponseBody
    public JsonResult<Traditionalconsult> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Traditionalconsult> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = traditionalconsultService.findAll(newpage, newlimit, startTime);
            count = traditionalconsultService.countNum(startTime);
        }else{
            list = traditionalconsultService.findAll(newpage,newlimit,years);
            count = traditionalconsultService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("TraditionalconsultGetByid")
    @ResponseBody
    public Traditionalconsult findAll(Integer id) {
        Traditionalconsult traditionalconsult = traditionalconsultService.findById(id);
        return traditionalconsult;
    }

    //返回单个数据
    @RequestMapping("updateTraditionalconsult")
    @ResponseBody
    public Result<Traditionalconsult> update(Traditionalconsult traditionalconsult) {
        return   ResultUtil.success(traditionalconsultService.update(traditionalconsult));
    }

    //返回单个数据
    @RequestMapping("addTraditionalconsult")
    @ResponseBody
    public Result<Traditionalconsult> addOrganization(Traditionalconsult traditionalconsult) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        traditionalconsult.setAddyear(year.toString());
        return   ResultUtil.success(traditionalconsultService.save(traditionalconsult));
    }

    //返回单个数据
    @RequestMapping("deleteTraditionalconsult")
    @ResponseBody
    public Result<Traditionalconsult> deleteOrganization(Integer id) {
        return   ResultUtil.success(traditionalconsultService.delete(id));
    }
}
