package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.SoftwarelegalDAO;
import com.zjweu.entity.Softwarelegal;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.SoftwarelegalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwarelegalServiceImpl  implements SoftwarelegalService {

    @Autowired
    private SoftwarelegalDAO softwarelegalDAO;

    @Override
    public ListDataJson<Softwarelegal> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Softwarelegal> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Softwarelegal> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Softwarelegal> pagesize = new Page<>(page,limit);
        IPage<Softwarelegal> iPage = softwarelegalDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Softwarelegal findById(Integer id) {
        QueryWrapper<Softwarelegal> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return softwarelegalDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Softwarelegal> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Softwarelegal> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = softwarelegalDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Softwarelegal softwarelegal) {
        int i = softwarelegalDAO.insert(softwarelegal);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Softwarelegal softwarelegal) {
        int i = softwarelegalDAO.updateById(softwarelegal);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = softwarelegalDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Softwarelegal> findByYear(String year) {
        QueryWrapper<Softwarelegal> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return softwarelegalDAO.selectList(queryWrapper);
    }
}
