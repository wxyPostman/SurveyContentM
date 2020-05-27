package com.zjweu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("organization")
public class Organization implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    //机构名称
    private String code;
    private String address;
    private String level;
    private String orgname;
    private String setupteam;
    private String setuptime;
    private String setupfile;
    private String headmanname;
    private String headmanjobtitle;
    private String headmanphone;
    private String department;
    private String directorname;
    private String directorjobtitle;
    private String directorphone;
    private String isclear;
    private String safedepartmentname;
    private Integer funds;
    private String safeleadername;
    private String safeleaderchangjobtitle;
    private String safeleaderjobphone;
    private String safeleaderphone;
    private String safeleaderemail;
    private String safedirectorname;
    private String safedirectorjobtitle;
    private String safedirectorjobphone;
    private String safedirectorphone;
    private String safedirectoremail;
    private String safeliaisonname;
    private String safeliaisonjobtitle;
    private String safeliaisonjobphone;
    private String safeliaisonphone;
    private String safeliaisonemail;
    private String safeliaisonwechat;
    private String infoleaderannex;
    private String infoleaderfilename;
    private String addyear;
}
