package com.zjweu.service;

import com.zjweu.entity.Train;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface TrainService {
    //查
    public ListDataJson<Train> findAll(Integer page, Integer limit, String year);

    public Train findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Train train);

    //改
    public boolean update(Train train);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Train> findByYear(String year);
}
