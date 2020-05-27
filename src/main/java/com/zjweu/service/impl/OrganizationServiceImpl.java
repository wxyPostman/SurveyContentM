package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjweu.dao.OrganizationDAO;
import com.zjweu.entity.Organization;
import com.zjweu.enums.ListDataJson;
import com.zjweu.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDAO organizationDAO;
    @Override
    public ListDataJson<Organization> findAll(Integer page, Integer limit, String year) {
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Organization> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");
//        QueryWrapper<Organization> wrapper = queryWrapper.and(wrappers -> wrappers.like("addyear", year).or().like("name", name));
        Page<Organization> pagesize = new Page<>(page,limit);
        IPage<Organization> iPage = organizationDAO.selectPage(pagesize,wrapper);
        return  new ListDataJson<>(iPage.getRecords(),iPage.getSize());
    }

    @Override
    public Organization findById(Integer id) {
        QueryWrapper<Organization> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return organizationDAO.selectOne(wrapper);
    }


    @Override
    public Long countNum(String year) {
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Organization> wrapper = queryWrapper.like("addyear", "%" + year + "%").orderBy(true,false,"id");
        long count = organizationDAO.selectCount(wrapper);
        return count;
    }

    @Override
    public boolean save(Organization organization) {
        int i = organizationDAO.insert(organization);
        return i == 1 ? true : false;
    }

    @Override
    public boolean update(Organization organization) {
        int i = organizationDAO.updateById(organization);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        int i = organizationDAO.deleteById(uid);
        return i == 1 ? true : false;
    }

    @Override
    public List<Organization> findByYear(String year) {
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("addyear", "%"+year+"%");
        return organizationDAO.selectList(queryWrapper);
    }
}
