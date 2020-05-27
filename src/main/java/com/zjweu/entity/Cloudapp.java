package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("cloudapp")
public class Cloudapp implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private String governmentcloudname;
    private Integer governmentcloudcpunumber;
    private Integer governmentcloudreserves;
    private String businesscloudname;
    private Integer commercialcloudcpunumber;
    private Integer commercialcloudreserves;
    private Integer selfbuiltcloudcpunumber;
    private Integer selfbuiltcloudvirtualmachinenumber;
    private Integer selfbuiltcloudservernumber;
    private Integer selfbuiltcloudstoragecapacity;
    private String addyear;

}