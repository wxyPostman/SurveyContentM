package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.AnnualvideoDAO;
import com.zjweu.entity.Annualvideo;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.AnnualvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnualvideoServiceImpl implements AnnualvideoService {
    @Autowired
    private AnnualvideoDAO annualvideoDAO;

    @Override
    public ListDataJson<Annualvideo> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Annualvideo> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Annualvideo> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Annualvideo> pagesize = new Page<>(page,limit);
        IPage<Annualvideo> iPage = annualvideoDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Annualvideo findById(Integer id) {
        QueryWrapper<Annualvideo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return annualvideoDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Annualvideo> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Annualvideo> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = annualvideoDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Annualvideo annualvideo) {
        int i = annualvideoDAO.insert(annualvideo);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Annualvideo annualvideo) {
        int i = annualvideoDAO.updateById(annualvideo);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = annualvideoDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Annualvideo> findByYear(String year) {
        QueryWrapper<Annualvideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return annualvideoDAO.selectList(queryWrapper);
    }
}
