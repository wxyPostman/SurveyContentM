package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.HardwareDAO;
import com.zjweu.entity.Hardware;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardwareServiceImpl implements HardwareService {
    @Autowired
    private HardwareDAO hardwareDAO;


    @Override
    public ListDataJson<Hardware> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Hardware> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Hardware> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Hardware> pagesize = new Page<>(page,limit);
        IPage<Hardware> iPage = hardwareDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Hardware findById(Integer id) {
        QueryWrapper<Hardware> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return hardwareDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Hardware> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Hardware> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = hardwareDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Hardware hardware) {
        int i = hardwareDAO.insert(hardware);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Hardware hardware) {
        int i = hardwareDAO.updateById(hardware);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = hardwareDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Hardware> findByYear(String year) {
        QueryWrapper<Hardware> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return hardwareDAO.selectList(queryWrapper);
    }
}
