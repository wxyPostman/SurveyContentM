package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {

    @TableId(value = "uid",type = IdType.AUTO)
    private  Integer  uid;
    private String  uname;
    private String  upassword;
    private String  uphone;
    private String  usrc;
}
