package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Visualnet;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.VisualnetService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class VisualnetController {

    @Autowired
    private VisualnetService visualnetService;

    //返回所有数据
    @RequestMapping("getVisualnet")
    @ResponseBody
    public JsonResult<Visualnet> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Visualnet> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = visualnetService.findAll(newpage, newlimit, startTime);
            count = visualnetService.countNum(startTime);
        }else{
            list = visualnetService.findAll(newpage,newlimit,years);
            count = visualnetService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("VisualnetGetByid")
    @ResponseBody
    public Visualnet findAll(Integer id) {
        Visualnet visualnet = visualnetService.findById(id);
        return visualnet;
    }

    //返回单个数据
    @RequestMapping("updateVisualnet")
    @ResponseBody
    public Result<Visualnet> update(Visualnet visualnet) {
        return   ResultUtil.success(visualnetService.update(visualnet));
    }

    //返回单个数据
    @RequestMapping("addVisualnet")
    @ResponseBody
    public Result<Visualnet> addOrganization(Visualnet visualnet) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        visualnet.setAddyear(year.toString());
        return   ResultUtil.success(visualnetService.save(visualnet));
    }

    //返回单个数据
    @RequestMapping("deleteVisualnet")
    @ResponseBody
    public Result<Visualnet> deleteOrganization(Integer id) {
        return   ResultUtil.success(visualnetService.delete(id));
    }

}
