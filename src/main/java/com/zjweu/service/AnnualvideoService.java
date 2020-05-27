package com.zjweu.service;

import com.zjweu.entity.Annualvideo;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface AnnualvideoService {
    //查
    public ListDataJson<Annualvideo> findAll(Integer page, Integer limit, String year);

    public Annualvideo findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Annualvideo annualvideo);

    //改
    public boolean update(Annualvideo annualvideo);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Annualvideo> findByYear(String year);
}
