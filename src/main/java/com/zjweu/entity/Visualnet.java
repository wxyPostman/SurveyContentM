package com.zjweu.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("visualnet")
public class Visualnet  implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private String meetingplace;
    private Float meetingarea;
    private Integer fitupyear;
    private Integer capacity;
    private String edition;
    private String linkspeed;
    private String operator;
    private String clientmodel;
    private String clientterminal;
    private String joinup;
    private String clienttype;
    private String addyear;
}
