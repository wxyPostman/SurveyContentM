package com.zjweu.service;

import com.zjweu.entity.Cloudapp;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface CloudappService {
    //查
    public ListDataJson<Cloudapp> findAll(Integer page, Integer limit, String year);

    public Cloudapp findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Cloudapp cloudapp);

    //改
    public boolean update(Cloudapp cloudapp);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Cloudapp> findByYear(String year);
}
