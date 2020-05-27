package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("hardware")
public class Hardware implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer computerterminalnumber;
    private Integer uav;
    private Integer fixedsatellitestation;
    private Integer portablesatellitestation;
    private Integer othersatellitefacilities;
    private Integer beidoufloodreport;
    private Integer fixedposition;
    private Integer dongzhongtong;
    private Integer jingzhongtong;
    private Integer clusterterminal;
    private Integer microwavelinelength;
    private Integer relaystationnumber;
    private String othercommunication;
    private Integer othercommunicationnumber;
    private Integer othercommunicationlinelength;
    private String addyear;
}