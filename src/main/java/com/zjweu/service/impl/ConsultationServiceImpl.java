package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.ConsultationDAO;
import com.zjweu.entity.Consultation;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl  implements ConsultationService {
    @Autowired
    private ConsultationDAO consultationDAO;

    @Override
    public ListDataJson<Consultation> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Consultation> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Consultation> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");

        Page<Consultation> pagesize = new Page<>(page,limit);
        IPage<Consultation> iPage = consultationDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Consultation findById(Integer id) {
        QueryWrapper<Consultation> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return consultationDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Consultation> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Consultation> wrapper = queryWrapper.like("addyear", "%" + year + "%");
        long count = consultationDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Consultation consultation) {
        int i = consultationDAO.insert(consultation);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Consultation consultation) {
        int i = consultationDAO.updateById(consultation);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = consultationDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Consultation> findByYear(String year) {
        QueryWrapper<Consultation> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return consultationDAO.selectList(queryWrapper);
    }
}
