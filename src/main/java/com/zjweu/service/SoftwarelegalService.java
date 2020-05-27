package com.zjweu.service;

import com.zjweu.entity.Softwarelegal;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface SoftwarelegalService {
    //查
    public ListDataJson<Softwarelegal> findAll(Integer page, Integer limit, String year);

    public Softwarelegal findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Softwarelegal softwarelegal);

    //改
    public boolean update(Softwarelegal softwarelegal);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Softwarelegal> findByYear(String year);
}
