package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("townshipvideo")
public class Townshipvideo  implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer townnumber;
    private Integer satnettownnumber;
    private Integer receivetownnumber;
    private Integer videotownnumber;
    private Integer villagenumber;
    private Integer satnetvillagenumber;
    private Integer receivevillagenumber;
    private Integer videovillagenumber;
    private String addyear;
}
