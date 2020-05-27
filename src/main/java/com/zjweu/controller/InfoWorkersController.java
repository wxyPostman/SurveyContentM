package com.zjweu.controller;


import com.zjweu.domain.Result;
import com.zjweu.entity.InfoWorkers;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.InfoWorkersService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

@Controller
public class InfoWorkersController {
    @Autowired
    private InfoWorkersService infoWorkersService;

    //返回所有数据
    @RequestMapping("getInfoworkers")
    @ResponseBody
    public JsonResult<InfoWorkers> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<InfoWorkers> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = infoWorkersService.findAll(newpage, newlimit, startTime);
            count = infoWorkersService.countNum(startTime);
        }else{
            list = infoWorkersService.findAll(newpage,newlimit,years);
            count = infoWorkersService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    @RequestMapping("InfoworkersGetById")
    @ResponseBody
    public InfoWorkers findAll(Integer id) {
        InfoWorkers organization = infoWorkersService.findById(id);
        return organization;
    }

    @RequestMapping("updateInfoworkers")
    @ResponseBody
    public Result<InfoWorkers> update(InfoWorkers infoWorkers) {
        ChangSaveMethod(infoWorkers);

        return   ResultUtil.success(infoWorkersService.update(infoWorkers));
    }

    @RequestMapping("addInfoworkers")
    @ResponseBody
    public Result<InfoWorkers> addOrganization(InfoWorkers infoWorkers) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        infoWorkers.setAddyear(year.toString());
        ChangSaveMethod(infoWorkers);


        return   ResultUtil.success(infoWorkersService.save(infoWorkers));
    }

    @RequestMapping("deleteInfoworkers")
    @ResponseBody
    public Result<InfoWorkers> deleteOrganization(Integer id) {
        return   ResultUtil.success(infoWorkersService.delete(id));
    }

    private void ChangSaveMethod(InfoWorkers infoWorkers) {
        String degree =infoWorkers.getDegree();
        Integer number = Integer.parseInt(degree);
        if(number != null){
            if(number == 0){
                infoWorkers.setDegree("博士");
            }else if(number == 1){
                infoWorkers.setDegree("硕士");
            }else if(number == 2){
                infoWorkers.setDegree("本科");
            }else if(number == 3){
                infoWorkers.setDegree("专科");
            }else if(number == 4){
                infoWorkers.setDegree("其它");
            }else{
                infoWorkers.setDegree("");
            }
        }

        String formation = infoWorkers.getFormation();
        Integer formationNumber = Integer.parseInt(formation);
        if(formationNumber != null){
            if(formationNumber == 0){
                infoWorkers.setFormation("正式员工");
            }else if(formationNumber == 1){
                infoWorkers.setFormation("临时人员");
            }else if(formationNumber == 2){
                infoWorkers.setFormation("借用人员");
            }else if(formationNumber == 3){
                infoWorkers.setFormation("驻场人员");
            }else if(formationNumber == 4){
                infoWorkers.setFormation("其它人员");
            }else{
                infoWorkers.setFormation("");
            }
        }
    }
}
