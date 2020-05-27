package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.SystemPlanDAO;
import com.zjweu.entity.SystemPlan;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.SystemPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPlanServiceImpl implements SystemPlanService {

    @Autowired
    private SystemPlanDAO systemPlanDAO;

    @Override
    public ListDataJson<SystemPlan> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<SystemPlan> queryWrapper = new QueryWrapper<>();
        QueryWrapper<SystemPlan> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<SystemPlan> pagesize = new Page<>(page,limit);
        IPage<SystemPlan> iPage = systemPlanDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public SystemPlan findById(Integer id) {
        QueryWrapper<SystemPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return systemPlanDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<SystemPlan> queryWrapper = new QueryWrapper<>();
        QueryWrapper<SystemPlan> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = systemPlanDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(SystemPlan systemPlan) {
        int i = systemPlanDAO.insert(systemPlan);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(SystemPlan systemPlan) {
        int i = systemPlanDAO.updateById(systemPlan);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = systemPlanDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<SystemPlan> findByYear(String year) {
        QueryWrapper<SystemPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return systemPlanDAO.selectList(queryWrapper);
    }
}
