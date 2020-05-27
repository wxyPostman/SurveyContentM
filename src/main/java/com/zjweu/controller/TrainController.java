package com.zjweu.controller;

import com.zjweu.domain.Result;
import com.zjweu.entity.Train;
import com.zjweu.enums.JsonResult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.TrainService;
import com.zjweu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;

    //返回所有数据
    @RequestMapping("trainGetAll")
    @ResponseBody
    public JsonResult<Train> findAll(HttpServletRequest request) {
        String startTime =request.getParameter("startTime");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Integer newpage = Integer.parseInt(page);
        Integer newlimit = Integer.parseInt(limit);
        ListDataJson<Train> list  = null;
        Long count;
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        String years = year.toString();
        if(startTime != null){
            list = trainService.findAll(newpage, newlimit, startTime);
            count = trainService.countNum(startTime);
        }else{
            list = trainService.findAll(newpage,newlimit,years);
            count = trainService.countNum(years);
        }
        return new JsonResult<>(0,"操作成功",list.getData(),count);
    }

    //返回单个数据
    @RequestMapping("trainGetByid")
    @ResponseBody
    public Train findAll(Integer id) {
        Train train = trainService.findById(id);
        return train;
    }

    //返回单个数据
    @RequestMapping("updateTrain")
    @ResponseBody
    public Result<Train> update(Train train) {
        return   ResultUtil.success(trainService.update(train));
    }

    //返回单个数据
    @RequestMapping("addTrain")
    @ResponseBody
    public Result<Train> addOrganization(Train train) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        train.setAddyear(year.toString());
        return   ResultUtil.success(trainService.save(train));
    }

    //返回单个数据
    @RequestMapping("deleteTrain")
    @ResponseBody
    public Result<Train> deleteOrganization(Integer id) {
        return   ResultUtil.success(trainService.delete(id));
    }
}
