package com.zjweu.service;

import com.zjweu.entity.Infocollection;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface InfocollectionService {
    //查
    public ListDataJson<Infocollection> findAll(Integer page, Integer limit, String year);

    public Infocollection findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Infocollection infocollection);

    //改
    public boolean update(Infocollection infocollection);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Infocollection> findByYear(String year);
}
