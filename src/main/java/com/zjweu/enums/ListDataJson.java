package com.zjweu.enums;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDataJson<T> {

    private List<T> data;
    private  Long count;
    public ListDataJson(Long count){
        this(null,count);
    }
}
