package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("consultation")
public class Consultation implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private String head;
    private String headphone;
    private String operator;
    private String operatorphone;
    private String uplinknet;
    private String downlinknet;
    private Integer lowerjoinnode;
    private String brand;
    private String ip;
    private String netmode;
    private String addyear;
}

