package com.zjweu.service;


import com.zjweu.entity.Organization;
import com.zjweu.entity.SystemPlan;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface SystemPlanService {
    //查
    public ListDataJson<SystemPlan> findAll(Integer page, Integer limit, String year);

    public SystemPlan findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(SystemPlan systemPlan);

    //改
    public boolean update(SystemPlan systemPlan);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<SystemPlan> findByYear(String year);
}
