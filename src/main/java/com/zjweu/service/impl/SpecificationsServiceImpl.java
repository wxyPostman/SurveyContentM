package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.SpecificationsDAO;
import com.zjweu.entity.Specifications;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.SpecificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationsServiceImpl implements SpecificationsService {

    @Autowired
    private SpecificationsDAO specificationsDAO;

    @Override
    public ListDataJson<Specifications> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Specifications> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Specifications> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Specifications> pagesize = new Page<>(page,limit);
        IPage<Specifications> iPage = specificationsDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<Specifications>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Specifications findById(Integer id) {
        QueryWrapper<Specifications> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return specificationsDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Specifications> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Specifications> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = specificationsDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Specifications specifications) {
        int i = specificationsDAO.insert(specifications);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Specifications specifications) {
        int i = specificationsDAO.updateById(specifications);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = specificationsDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Specifications> findByYear(String year) {
        QueryWrapper<Specifications> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return specificationsDAO.selectList(queryWrapper);
    }
}
