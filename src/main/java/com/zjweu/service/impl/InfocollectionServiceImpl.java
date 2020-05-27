package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.InfocollectionDAO;
import com.zjweu.entity.Infocollection;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.InfocollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfocollectionServiceImpl implements InfocollectionService {
    @Autowired
    private InfocollectionDAO infocollectionDAO;

    @Override
    public ListDataJson<Infocollection> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Infocollection> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Infocollection> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Infocollection> pagesize = new Page<>(page,limit);
        IPage<Infocollection> iPage = infocollectionDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Infocollection findById(Integer id) {
        QueryWrapper<Infocollection> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return infocollectionDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Infocollection> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Infocollection> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = infocollectionDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Infocollection infocollection) {
        int i = infocollectionDAO.insert(infocollection);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Infocollection infocollection) {
        int i = infocollectionDAO.updateById(infocollection);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = infocollectionDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Infocollection> findByYear(String year) {
        QueryWrapper<Infocollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return infocollectionDAO.selectList(queryWrapper);
    }
}
