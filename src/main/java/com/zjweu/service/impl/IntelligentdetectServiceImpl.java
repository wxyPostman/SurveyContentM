package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.IntelligentdetectDAO;
import com.zjweu.entity.Intelligentdetect;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.IntelligentdetectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntelligentdetectServiceImpl  implements IntelligentdetectService {
    @Autowired
    private IntelligentdetectDAO intelligentdetectDAO;


    @Override
    public ListDataJson<Intelligentdetect> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Intelligentdetect> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Intelligentdetect> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Intelligentdetect> pagesize = new Page<>(page,limit);
        IPage<Intelligentdetect> iPage = intelligentdetectDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Intelligentdetect findById(Integer id) {
        QueryWrapper<Intelligentdetect> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return intelligentdetectDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Intelligentdetect> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Intelligentdetect> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = intelligentdetectDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Intelligentdetect intelligentdetect) {
        int i = intelligentdetectDAO.insert(intelligentdetect);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Intelligentdetect intelligentdetect) {
        int i = intelligentdetectDAO.updateById(intelligentdetect);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = intelligentdetectDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Intelligentdetect> findByYear(String year) {
        QueryWrapper<Intelligentdetect> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return intelligentdetectDAO.selectList(queryWrapper);
    }
}
