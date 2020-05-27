package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.VideomonitorDAO;
import com.zjweu.entity.Videomonitor;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.VideomonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideomonitorServiceImpl  implements VideomonitorService {

    @Autowired
    private VideomonitorDAO videomonitorDAO;

    @Override
    public ListDataJson<Videomonitor> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Videomonitor> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Videomonitor> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Videomonitor> pagesize = new Page<>(page,limit);
        IPage<Videomonitor> iPage = videomonitorDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Videomonitor findById(Integer id) {
        QueryWrapper<Videomonitor> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return videomonitorDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Videomonitor> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Videomonitor> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = videomonitorDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Videomonitor videomonitor) {
        int i = videomonitorDAO.insert(videomonitor);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Videomonitor videomonitor) {
        int i = videomonitorDAO.updateById(videomonitor);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = videomonitorDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Videomonitor> findByYear(String year) {
        QueryWrapper<Videomonitor> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return videomonitorDAO.selectList(queryWrapper);
    }
}
