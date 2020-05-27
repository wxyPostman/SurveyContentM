package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.TraditionalconsultDAO;
import com.zjweu.entity.Traditionalconsult;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.TraditionalconsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraditionalconsultServiceImpl implements TraditionalconsultService {

    @Autowired
    private TraditionalconsultDAO traditionalconsultDAO;

    @Override
    public ListDataJson<Traditionalconsult> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Traditionalconsult> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Traditionalconsult> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Traditionalconsult> pagesize = new Page<>(page,limit);
        IPage<Traditionalconsult> iPage = traditionalconsultDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Traditionalconsult findById(Integer id) {
        QueryWrapper<Traditionalconsult> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return traditionalconsultDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Traditionalconsult> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Traditionalconsult> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = traditionalconsultDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Traditionalconsult traditionalconsult) {
        int i = traditionalconsultDAO.insert(traditionalconsult);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Traditionalconsult traditionalconsult) {
        int i = traditionalconsultDAO.updateById(traditionalconsult);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = traditionalconsultDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Traditionalconsult> findByYear(String year) {
        QueryWrapper<Traditionalconsult> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return traditionalconsultDAO.selectList(queryWrapper);
    }
}
