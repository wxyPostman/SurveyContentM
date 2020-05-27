package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Networkaccess;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.NetworkaccessService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class NetworkaccessController {

    @Autowired
    private NetworkaccessService networkaccessService;


    //返回所有数据
    @RequestMapping("getNetworkaccess")
    @ResponseBody
    public JsonResult<Networkaccess> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Networkaccess> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = networkaccessService.findAll(newpage, newlimit, startTime);
            count = networkaccessService.countNum(startTime);
        }else{
            list = networkaccessService.findAll(newpage,newlimit,years);
            count = networkaccessService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    @RequestMapping("NetworkaccessGetByid")
    @ResponseBody
    public Networkaccess findAll(Integer id) {
        Networkaccess networkaccess = networkaccessService.findById(id);
        return networkaccess;
    }

    //返回单个数据
    @RequestMapping("updateNetworkaccess")
    @ResponseBody
    public Result<Networkaccess> update(Networkaccess networkaccess) {
        return   ResultUtil.success(networkaccessService.update(networkaccess));
    }

    //返回单个数据
    @RequestMapping("addNetworkaccess")
    @ResponseBody
    public Result<Networkaccess> addOrganization(Networkaccess networkaccess) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        networkaccess.setAddyear(year.toString());
        return   ResultUtil.success(networkaccessService.save(networkaccess));
    }

    //返回单个数据
    @RequestMapping("deleteNetworkaccess")
    @ResponseBody
    public Result<Networkaccess> deleteOrganization(Integer id) {
        return   ResultUtil.success(networkaccessService.delete(id));
    }
}
