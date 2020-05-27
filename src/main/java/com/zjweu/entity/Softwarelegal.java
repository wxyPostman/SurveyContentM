package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("softwarelegal")
public class Softwarelegal  implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private String leaddepartment;
    private Float fund;
    private Integer operate;
    private Integer officesoftware;
    private Integer antivirus;
    private String haveleadgroup;
    private String haveworkgroup;
    private String haveprocurement;
    private String haveasset;
    private String havedispose;
    private String haveusage;
    private String haveassess;
    private String addyear;
}
