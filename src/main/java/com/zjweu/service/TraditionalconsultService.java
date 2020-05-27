package com.zjweu.service;

import com.zjweu.entity.Traditionalconsult;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface TraditionalconsultService  {
    //查
    public ListDataJson<Traditionalconsult> findAll(Integer page, Integer limit, String year);

    public Traditionalconsult findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Traditionalconsult traditionalconsult);

    //改
    public boolean update(Traditionalconsult traditionalconsult);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Traditionalconsult> findByYear(String year);
}
