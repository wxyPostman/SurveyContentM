package com.zjweu.service;

import com.zjweu.entity.Intelligentdetect;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface IntelligentdetectService {
    //查
    public ListDataJson<Intelligentdetect> findAll(Integer page, Integer limit, String year);

    public Intelligentdetect findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Intelligentdetect intelligentdetect);

    //改
    public boolean update(Intelligentdetect intelligentdetect);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Intelligentdetect> findByYear(String year);
}
