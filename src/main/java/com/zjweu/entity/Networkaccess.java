package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("networkaccess")
public class Networkaccess implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer orders;
    private String networkaccessform;
    private String networkconnectedunit;
    private String isleasedline;
    private String supplier;
    private String networkbandwidth;
    private Integer desktopterminalnumber;
    private Integer switchingequipmentnumber;
    private String addyear;
}
