package com.zjweu.service;

import com.zjweu.entity.Visualnet;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface VisualnetService {
    //查
    public ListDataJson<Visualnet> findAll(Integer page, Integer limit, String year);

    public Visualnet findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Visualnet visualnet);

    //改
    public boolean update(Visualnet visualnet);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Visualnet> findByYear(String year);
}
