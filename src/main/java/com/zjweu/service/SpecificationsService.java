package com.zjweu.service;

import com.zjweu.entity.Organization;
import com.zjweu.entity.Specifications;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface SpecificationsService {
    //查
    public ListDataJson<Specifications> findAll(Integer page, Integer limit, String year);

    public Specifications findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Specifications specifications);

    //改
    public boolean update(Specifications specifications);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Specifications> findByYear(String year);
}
