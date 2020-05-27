package com.zjweu.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult <T> {
    private Integer code;
    private String message;
    private List<T> data;
    private  long count;
    public JsonResult(Integer code,String message,long count){
        this(code,message,null,count);
    }
}
