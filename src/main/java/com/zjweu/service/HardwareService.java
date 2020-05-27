package com.zjweu.service;

import com.zjweu.entity.Hardware;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface HardwareService {
    //查
    public ListDataJson<Hardware> findAll(Integer page, Integer limit, String year);

    public Hardware findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Hardware hardware);

    //改
    public boolean update(Hardware hardware);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Hardware> findByYear(String year);
}
