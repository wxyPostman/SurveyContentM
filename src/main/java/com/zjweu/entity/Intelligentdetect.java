package com.zjweu.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("intelligentdetect")
public class Intelligentdetect implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer intelligentsensornumber;
    private String applicationtype;
    private String haveintelligentcontrolsystem;
    private String intelligentcontrolsystemname;
    private Integer systemmonitorpointnumber;
    private String applicationscenario;
    private String addyear;
}