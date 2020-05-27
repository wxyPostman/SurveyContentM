package com.zjweu.service;

import com.zjweu.entity.Organization;
import com.zjweu.enums.ListDataJson;

import java.util.List;

public interface OrganizationService {
    //查
    public ListDataJson<Organization> findAll(Integer page, Integer limit, String year);

    public Organization findById(Integer id);

    public Long countNum(String year);

    //增
    public boolean save(Organization organization);

    //改
    public boolean update(Organization organization);

    //删
    public boolean delete(Integer uid);

    //搜索
    public List<Organization> findByYear(String year);
}
