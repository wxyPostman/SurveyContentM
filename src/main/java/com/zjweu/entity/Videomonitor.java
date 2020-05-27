package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.imageio.plugins.common.I18N;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("videomonitor")
public class Videomonitor  implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private Integer reservoirselfbuiltnumber;
    private Integer reservoirrentnumber;
    private Integer reservoirsharenumber;
    private String reservoirsupplier;
    private String reservoirsharesource;
    private Integer damselfbuiltnumber;
    private Integer damrentnumber;
    private Integer damsharenumber;
    private String damsupplier;
    private String damsharesource;
    private Integer riverselfbuiltnumber;
    private Integer riverrentnumber;
    private Integer riversharenumber;
    private String riversupplier;
    private String riversharesource;
    private Integer seawallselfbuiltnumber;
    private Integer seawallrentnumber;
    private Integer seawallsharenumber;
    private String seawallsupplier;
    private String seawallsharesource;
    private Integer otherselfbuiltnumber;
    private Integer otherrentnumber;
    private Integer othersharenumber;
    private String othersupplier;
    private String othersharesource;
    private String addyear;
}
