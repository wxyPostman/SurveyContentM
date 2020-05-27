package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("projectinvest")
public class Projectinvest implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private String entryname;
    private String projectbriefintroduction;
    private String approvalnumber;
    private String projecttype;
    private String itemcategory;
    private Integer constructioncycle;
    private Float centralinvestment;
    private Float localinvestment;
    private Float otherprojectinvestment;
    private Float annualinvestment;
    private String isaffiliatedinformationproject;
    private String majorfunction;
    private String systemcategory;
    private String addyear;
}