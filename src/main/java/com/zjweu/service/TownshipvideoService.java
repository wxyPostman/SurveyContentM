package com.zjweu.service;

import com.zjweu.entity.Townshipvideo;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface TownshipvideoService {
    //查
    public ListDataJson<Townshipvideo> findAll(Integer page, Integer limit, String year);

    public Townshipvideo findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Townshipvideo townshipvideo);

    //改
    public boolean update(Townshipvideo townshipvideo);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Townshipvideo> findByYear(String year);
}
