package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Videomonitor;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.VideomonitorService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class VideomonitorController {

    @Autowired
    private VideomonitorService videomonitorService;


    //返回所有数据
    @RequestMapping("getVideomonitor")
    @ResponseBody
    public JsonResult<Videomonitor> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Videomonitor> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = videomonitorService.findAll(newpage, newlimit, startTime);
            count = videomonitorService.countNum(startTime);
        }else{
            list = videomonitorService.findAll(newpage,newlimit,years);
            count = videomonitorService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    @RequestMapping("VideomonitorGetByid")
    @ResponseBody
    public Videomonitor findAll(Integer id) {
        Videomonitor videomonitor = videomonitorService.findById(id);
        return videomonitor;
    }

    @RequestMapping("updateVideomonitor")
    @ResponseBody
    public Result<Videomonitor> update(Videomonitor videomonitor) {
        return   ResultUtil.success(videomonitorService.update(videomonitor));
    }

    @RequestMapping("addVideomonitor")
    @ResponseBody
    public Result<Videomonitor> addOrganization(Videomonitor videomonitor) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        videomonitor.setAddyear(year.toString());
        return   ResultUtil.success(videomonitorService.save(videomonitor));
    }

    //返回单个数据
    @RequestMapping("deleteVideomonitor")
    @ResponseBody
    public Result<Videomonitor> deleteOrganization(Integer id) {
        return   ResultUtil.success(videomonitorService.delete(id));
    }
}
