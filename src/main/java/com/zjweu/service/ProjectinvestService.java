package com.zjweu.service;

import com.zjweu.entity.Projectinvest;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface ProjectinvestService {
    //查
    public ListDataJson<Projectinvest> findAll(Integer page, Integer limit, String year);

    public Projectinvest findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Projectinvest projectinvest);

    //改
    public boolean update(Projectinvest projectinvest);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Projectinvest> findByYear(String year);
}
