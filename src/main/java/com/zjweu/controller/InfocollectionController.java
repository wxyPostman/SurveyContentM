package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Infocollection;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.InfocollectionService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class InfocollectionController {

    @Autowired
    private InfocollectionService infocollectionService;


    //返回所有数据
    @RequestMapping("getInfocollection")
    @ResponseBody
    public JsonResult<Infocollection> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Infocollection> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = infocollectionService.findAll(newpage, newlimit, startTime);
            count = infocollectionService.countNum(startTime);
        }else{
            list = infocollectionService.findAll(newpage,newlimit,years);
            count = infocollectionService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    @RequestMapping("InfocollectionGetByid")
    @ResponseBody
    public Infocollection findAll(Integer id) {
        Infocollection infocollection = infocollectionService.findById(id);
        return infocollection;
    }

    @RequestMapping("updateInfocollection")
    @ResponseBody
    public Result<Infocollection> update(Infocollection infocollection) {
        return   ResultUtil.success(infocollectionService.update(infocollection));
    }

    @RequestMapping("addInfocollection")
    @ResponseBody
    public Result<Infocollection> addOrganization(Infocollection infocollection) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        infocollection.setAddyear(year.toString());
        return   ResultUtil.success(infocollectionService.save(infocollection));
    }

    @RequestMapping("deleteInfocollection")
    @ResponseBody
    public Result<Infocollection> deleteOrganization(Integer id) {
        return   ResultUtil.success(infocollectionService.delete(id));
    }
}
