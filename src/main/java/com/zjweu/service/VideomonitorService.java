package com.zjweu.service;

import com.zjweu.entity.Videomonitor;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface VideomonitorService {
    //查
    public ListDataJson<Videomonitor> findAll(Integer page, Integer limit, String year);

    public Videomonitor findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Videomonitor videomonitor);

    //改
    public boolean update(Videomonitor videomonitor);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Videomonitor> findByYear(String year);
}
