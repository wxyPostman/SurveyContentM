package com.zjweu.service;

import com.zjweu.entity.Consultation;
import com.zjweu.entity.InfoWorkers;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface ConsultationService {
    //查
    public ListDataJson<Consultation> findAll(Integer page, Integer limit, String year);

    public Consultation findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Consultation consultation);

    //改
    public boolean update(Consultation consultation);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Consultation> findByYear(String year);
}
