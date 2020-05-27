package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.ServerroomDAO;
import com.zjweu.entity.Serverroom;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.ServerroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerroomServiceImpl implements ServerroomService {

    @Autowired
    private ServerroomDAO serverroomDAO;

    @Override
    public ListDataJson<Serverroom> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Serverroom> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Serverroom> wrapper = queryWrapper.like("addyear", "%" + year + "%");

        Page<Serverroom> pagesize = new Page<>(page,limit);
        IPage<Serverroom> iPage = serverroomDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Serverroom findById(Integer id) {
        QueryWrapper<Serverroom> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return serverroomDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Serverroom> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Serverroom> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");
        long count = serverroomDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Serverroom serverroom) {
        int i = serverroomDAO.insert(serverroom);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Serverroom serverroom) {
        int i = serverroomDAO.updateById(serverroom);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = serverroomDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Serverroom> findByYear(String year) {
        QueryWrapper<Serverroom> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return serverroomDAO.selectList(queryWrapper);
    }
}
