package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.TownshipvideoDAO;
import com.zjweu.entity.Townshipvideo;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.TownshipvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownshipvideoServiceImpl implements TownshipvideoService {

    @Autowired
    private TownshipvideoDAO townshipvideoDAO;
    @Override
    public ListDataJson<Townshipvideo> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Townshipvideo> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Townshipvideo> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Townshipvideo> pagesize = new Page<>(page,limit);
        IPage<Townshipvideo> iPage = townshipvideoDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Townshipvideo findById(Integer id) {
        QueryWrapper<Townshipvideo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return townshipvideoDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Townshipvideo> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Townshipvideo> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = townshipvideoDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Townshipvideo townshipvideo) {
        int i = townshipvideoDAO.insert(townshipvideo);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Townshipvideo townshipvideo) {
        int i = townshipvideoDAO.updateById(townshipvideo);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = townshipvideoDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Townshipvideo> findByYear(String year) {
        QueryWrapper<Townshipvideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return townshipvideoDAO.selectList(queryWrapper);
    }
}
