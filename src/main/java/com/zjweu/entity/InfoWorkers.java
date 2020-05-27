package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("infoworkers")
public class InfoWorkers implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private  String name;
    private String sex;
    private String birthday;
    private String profession;
    private String degree;
    private String department;
    private String formation;
    private String operations;
    private String mainjob;
    private String phone;
    private String email;
    private String addyear;
    private String code;
    private String address;
    private String level;
    private String jobphone;
    private String jobname;
}
