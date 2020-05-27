package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("specifications")
public class Specifications implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String specificationsname;
    private String specificationsstandardname;
    private String specifications;
    private String maineditor;
    private String userange;
    private String releasetime;
    private String operatime;
    private String addyear;
}
