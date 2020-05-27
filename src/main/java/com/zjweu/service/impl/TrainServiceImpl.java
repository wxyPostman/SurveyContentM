package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.TrainDAO;
import com.zjweu.entity.Train;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainDAO trainDAO;

    @Override
    public ListDataJson<Train> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Train> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Train> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Train> pagesize = new Page<>(page,limit);
        IPage<Train> iPage = trainDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Train findById(Integer id) {
        QueryWrapper<Train> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return trainDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Train> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Train> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = trainDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Train train) {
        int i = trainDAO.insert(train);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Train train) {
        int i = trainDAO.updateById(train);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = trainDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Train> findByYear(String year) {
        QueryWrapper<Train> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return trainDAO.selectList(queryWrapper);
    }
}
