package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.ProjectinvestDAO;
import com.zjweu.entity.Projectinvest;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.ProjectinvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectinvestServiceImpl implements ProjectinvestService {
    @Autowired
    private ProjectinvestDAO projectinvestDAO;


    @Override
    public ListDataJson<Projectinvest> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Projectinvest> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Projectinvest> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Projectinvest> pagesize = new Page<>(page,limit);
        IPage<Projectinvest> iPage = projectinvestDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Projectinvest findById(Integer id) {
        QueryWrapper<Projectinvest> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return projectinvestDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Projectinvest> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Projectinvest> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = projectinvestDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Projectinvest projectinvest) {
        int i = projectinvestDAO.insert(projectinvest);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Projectinvest projectinvest) {
        int i = projectinvestDAO.updateById(projectinvest);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = projectinvestDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Projectinvest> findByYear(String year) {
        QueryWrapper<Projectinvest> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return projectinvestDAO.selectList(queryWrapper);
    }
}
