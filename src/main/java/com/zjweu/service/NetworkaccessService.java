package com.zjweu.service;

import com.zjweu.entity.Networkaccess;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface NetworkaccessService {
    //查
    public ListDataJson<Networkaccess> findAll(Integer page, Integer limit, String year);

    public Networkaccess findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Networkaccess networkaccess);

    //改
    public boolean update(Networkaccess networkaccess);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Networkaccess> findByYear(String year);
}
