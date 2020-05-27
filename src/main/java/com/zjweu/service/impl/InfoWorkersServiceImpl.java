package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.InfoWorkersDAO;
import com.zjweu.entity.InfoWorkers;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.InfoWorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoWorkersServiceImpl implements InfoWorkersService {

    @Autowired
    private InfoWorkersDAO infoWorkersDAO;

    @Override
    public ListDataJson<InfoWorkers> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<InfoWorkers> queryWrapper = new QueryWrapper<>();
        QueryWrapper<InfoWorkers> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<InfoWorkers> pagesize = new Page<>(page,limit);
        IPage<InfoWorkers> iPage = infoWorkersDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public InfoWorkers findById(Integer id) {
        QueryWrapper<InfoWorkers> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return infoWorkersDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<InfoWorkers> queryWrapper = new QueryWrapper<>();
        QueryWrapper<InfoWorkers> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = infoWorkersDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(InfoWorkers infoWorkers) {
        int i = infoWorkersDAO.insert(infoWorkers);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(InfoWorkers infoWorkers) {
        int i = infoWorkersDAO.updateById(infoWorkers);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = infoWorkersDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<InfoWorkers> findByYear(String year) {
        QueryWrapper<InfoWorkers> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return infoWorkersDAO.selectList(queryWrapper);
    }
}
