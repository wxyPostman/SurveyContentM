package com.zjweu.service;

import com.zjweu.entity.Serverroom;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface ServerroomService {
    //查
    public ListDataJson<Serverroom> findAll(Integer page, Integer limit, String year);

    public Serverroom findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Serverroom serverroom);

    //改
    public boolean update(Serverroom serverroom);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Serverroom> findByYear(String year);
}
