package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.CloudappDAO;
import com.zjweu.entity.Cloudapp;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.CloudappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudappServiceImpl implements CloudappService {

    @Autowired
    private CloudappDAO cloudappDAO;


    @Override
    public ListDataJson<Cloudapp> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Cloudapp> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Cloudapp> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Cloudapp> pagesize = new Page<>(page,limit);
        IPage<Cloudapp> iPage = cloudappDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Cloudapp findById(Integer id) {
        QueryWrapper<Cloudapp> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return cloudappDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Cloudapp> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Cloudapp> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = cloudappDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Cloudapp cloudapp) {
        int i = cloudappDAO.insert(cloudapp);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Cloudapp cloudapp) {
        int i = cloudappDAO.updateById(cloudapp);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = cloudappDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Cloudapp> findByYear(String year) {
        QueryWrapper<Cloudapp> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return cloudappDAO.selectList(queryWrapper);
    }
}
