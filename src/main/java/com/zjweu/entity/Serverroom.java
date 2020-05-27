package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("serverroom")
public class Serverroom implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer computerroomarea;
    private Integer monitorsum;
    private Integer videotapeholdtime;
    private Integer totalserversum;
    private Integer towerservernumber;
    private Integer bladeservernumber;
    private Integer rackservernumber;
    private Integer servercabinetnumber;
    private Integer virtualmachinenumber;
    private String softwaremodel;
    private String haveselfbuiltmachineroom;
    private String haveclimatecontrol;
    private String haveautomaticcontrol;
    private String haveaccesscontrol;
    private String haveups;
    private String havecomputerroommonitor;
    private String cameratype;
    private String servermanagementmode;
    private String addyear;
}
