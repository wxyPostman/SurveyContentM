package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("infocollection")
public class Infocollection implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer hydrologycollectnumber;
    private Integer hydrologyautocollectnumber;
    private Integer soilretentioncollectnumber;
    private Integer soilretentionautocollectnumber;
    private Integer waterresourcecollectnumber;
    private Integer waterresourceautocollectnumber;
    private Integer ecologycollectnumber;
    private Integer ecologyautocollectnumber;
    private Integer irrigationworkscollectnumber;
    private Integer irrigationworksautocollectnumber;
    private Integer ruralirrigationcollectnumber;
    private Integer ruralirrigationautocollectnumber;
    private Integer othercollectnumber;
    private Integer otherautocollectnumber;
    private String othercollectname;
    private String addyear;
}