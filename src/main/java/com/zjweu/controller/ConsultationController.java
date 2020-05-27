package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Consultation;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.ConsultationService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    //返回所有数据
    @RequestMapping("getConsultation")
    @ResponseBody
    public JsonResult<Consultation> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Consultation> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = consultationService.findAll(newpage, newlimit, startTime);
            count = consultationService.countNum(startTime);
        }else{
            list = consultationService.findAll(newpage,newlimit,years);
            count = consultationService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("ConsultationById")
    @ResponseBody
    public Consultation findAll(Integer id) {
        Consultation consultation = consultationService.findById(id);
        return consultation;
    }

    //返回单个数据
    @RequestMapping("updateConsultation")
    @ResponseBody
    public Result<Consultation> update(Consultation consultation) {
        return   ResultUtil.success(consultationService.update(consultation));
    }

    //返回单个数据
    @RequestMapping("addConsultation")
    @ResponseBody
    public Result<Consultation> addOrganization(Consultation consultation) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        consultation.setAddyear(year.toString());
        return   ResultUtil.success(consultationService.save(consultation));
    }

    //返回单个数据
    @RequestMapping("deleteConsultation")
    @ResponseBody
    public Result<Consultation> deleteOrganization(Integer id) {
        return   ResultUtil.success(consultationService.delete(id));
    }
}
