package com.zjweu.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("train")
public class Train  implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private String code;
    private String address;
    private String level;
    private String unitname;
    private String trainname;
    private Integer trainnumber;
    private Float traindays;
    private String trainstartdate;
    private String trainobject;
    private String addyear;

}
