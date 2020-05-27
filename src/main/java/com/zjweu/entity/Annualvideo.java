package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("annualvideo")
public class Annualvideo implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer typhoonfrequency;
    private Integer typhoonnumber;
    private Integer waterfrequency;
    private Integer waternumber;
    private Integer floodfrequency;
    private Integer floodnumber;
    private Integer otherfrequency;
    private Integer othernumber;
    private String addyear;
}