package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Annualvideo;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.AnnualvideoService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class AnnualcvideoController {
    @Autowired
    private AnnualvideoService annualvideoService;


    //返回所有数据
    @RequestMapping("getAnnualvideo")
    @ResponseBody
    public JsonResult<Annualvideo> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Annualvideo> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = annualvideoService.findAll(newpage, newlimit, startTime);
            count = annualvideoService.countNum(startTime);
        }else{
            list = annualvideoService.findAll(newpage,newlimit,years);
            count = annualvideoService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("AnnualvideoGetByid")
    @ResponseBody
    public Annualvideo findAll(Integer id) {
        Annualvideo visualnet = annualvideoService.findById(id);
        return visualnet;
    }

    //更新数据
    @RequestMapping("updateAnnualvideo")
    @ResponseBody
    public Result<Annualvideo> update(Annualvideo annualvideo) {
        return   ResultUtil.success(annualvideoService.update(annualvideo));
    }

    //新增数据
    @RequestMapping("addAnnualvideo")
    @ResponseBody
    public Result<Annualvideo> addOrganization(Annualvideo annualvideo) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        annualvideo.setAddyear(year.toString());
        return   ResultUtil.success(annualvideoService.save(annualvideo));
    }

    //删除数据
    @RequestMapping("deleteAnnualvideo")
    @ResponseBody
    public Result<Annualvideo> deleteOrganization(Integer id) {
        return   ResultUtil.success(annualvideoService.delete(id));
    }
}
