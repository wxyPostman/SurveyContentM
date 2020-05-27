package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.NetworkaccessDAO;
import com.zjweu.entity.Networkaccess;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.NetworkaccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkaccessServiceImpl implements NetworkaccessService {
    @Autowired
    private NetworkaccessDAO networkaccessDAO;


    @Override
    public ListDataJson<Networkaccess> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Networkaccess> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Networkaccess> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Networkaccess> pagesize = new Page<>(page,limit);
        IPage<Networkaccess> iPage = networkaccessDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Networkaccess findById(Integer id) {
        QueryWrapper<Networkaccess> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return networkaccessDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Networkaccess> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Networkaccess> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = networkaccessDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Networkaccess networkaccess) {
        int i = networkaccessDAO.insert(networkaccess);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Networkaccess networkaccess) {
        int i = networkaccessDAO.updateById(networkaccess);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = networkaccessDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Networkaccess> findByYear(String year) {
        QueryWrapper<Networkaccess> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return networkaccessDAO.selectList(queryWrapper);
    }
}
