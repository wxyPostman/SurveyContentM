package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("traditionalconsult")
public class Traditionalconsult implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer orders;
    private Float meetingarea;
    private Integer fitupyear;
    private Integer capacity;
    private String displaydevice;
    private Integer cameranumber;
    private String displayresolution;
    private String camerabrand;
    private Integer screensize;
    private String cameraresolution;
    private String terminalbrandmodel;
    private Integer microphonenumber;
    private String terminalip;
    private Integer inputlinenumber;
    private String kvmbrand;
    private Integer outputline;
    private String supconbrand;
    private String isspecialmeetingroom;
    private String microphonetype;
    private String isindependentsupcon;
    private String kvmtype;
    private String addyear;
}
