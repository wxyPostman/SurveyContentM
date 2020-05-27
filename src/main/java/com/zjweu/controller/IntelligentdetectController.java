package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Intelligentdetect;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.IntelligentdetectService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class IntelligentdetectController {

    @Autowired
    private IntelligentdetectService intelligentdetectService;


    //返回所有数据
    @RequestMapping("getIntelligentdetect")
    @ResponseBody
    public JsonResult<Intelligentdetect> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Intelligentdetect> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = intelligentdetectService.findAll(newpage, newlimit, startTime);
            count = intelligentdetectService.countNum(startTime);
        }else{
            list = intelligentdetectService.findAll(newpage,newlimit,years);
            count = intelligentdetectService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    @RequestMapping("IntelligentdetectGetByid")
    @ResponseBody
    public Intelligentdetect findAll(Integer id) {
        Intelligentdetect intelligentdetect = intelligentdetectService.findById(id);
        return intelligentdetect;
    }

    @RequestMapping("updateIntelligentdetect")
    @ResponseBody
    public Result<Intelligentdetect> update(Intelligentdetect intelligentdetect) {
        return   ResultUtil.success(intelligentdetectService.update(intelligentdetect));
    }

    @RequestMapping("addIntelligentdetect")
    @ResponseBody
    public Result<Intelligentdetect> addOrganization(Intelligentdetect intelligentdetect) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        intelligentdetect.setAddyear(year.toString());
        return   ResultUtil.success(intelligentdetectService.save(intelligentdetect));
    }

    @RequestMapping("deleteIntelligentdetect")
    @ResponseBody
    public Result<Intelligentdetect> deleteOrganization(Integer id) {
        return   ResultUtil.success(intelligentdetectService.delete(id));
    }
}
