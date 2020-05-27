package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("systemplan")
public class SystemPlan  implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String name;
    private String  planname;
    private String approvalunit;
    private String releasetime;
    private String systemname;
    private String num;
    private String userange;
    private String dept;
    private String promulgationtime;
    private String addyear;
    private String managename;
    private String readymanagename;
    private String isplan;
    private String ismanage;
}
