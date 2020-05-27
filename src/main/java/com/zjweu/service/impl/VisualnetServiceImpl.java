package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.VisualnetDAO;
import com.zjweu.entity.Visualnet;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.VisualnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualnetServiceImpl implements VisualnetService {

    @Autowired
    private VisualnetDAO visualnetDAO;

    @Override
    public ListDataJson<Visualnet> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Visualnet> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Visualnet> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Visualnet> pagesize = new Page<>(page,limit);
        IPage<Visualnet> iPage = visualnetDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Visualnet findById(Integer id) {
        QueryWrapper<Visualnet> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return visualnetDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Visualnet> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Visualnet> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = visualnetDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Visualnet visualnet) {
        int i = visualnetDAO.insert(visualnet);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Visualnet visualnet) {
        int i = visualnetDAO.updateById(visualnet);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = visualnetDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Visualnet> findByYear(String year) {
        QueryWrapper<Visualnet> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return visualnetDAO.selectList(queryWrapper);
    }
}
