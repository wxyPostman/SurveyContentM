package com.zjweu.service;

import com.zjweu.entity.InfoWorkers;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface InfoWorkersService {
    //查
    public ListDataJson<InfoWorkers> findAll(Integer page, Integer limit, String year);

    public InfoWorkers findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(InfoWorkers infoWorkers);

    //改
    public boolean update(InfoWorkers infoWorkers);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<InfoWorkers> findByYear(String year);
}
