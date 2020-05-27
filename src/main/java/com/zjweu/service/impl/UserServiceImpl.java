package com.zjweu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjweu.dao.UserDAO;
import com.zjweu.entity.User;
import com.zjweu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean save(User user) {
        int i = userDAO.insert(user);
        return i == 1 ? true : false;
    }


    @Override
    public boolean update(User user) {
        int i = userDAO.updateById(user);
        return i == 1 ? true : false;
    }

    @Override
    public boolean delete(Integer uid) {
        return false;
    }

    @Override
    public boolean CountByUname(String uname) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
       queryWrapper.eq("uname", uname);
        Integer count = userDAO.selectCount(queryWrapper);
        return count == 1 ? false : true;
    }

    @Override
    public User findByUname(String uname) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("uname", uname);
        return userDAO.selectOne(wrapper);
    }

    @Override
    public boolean CountByPhone(String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uphone", phone);
        Integer count = userDAO.selectCount(queryWrapper);
        return count == 1 ? false : true;
    }

    @Override
    public User findById(Integer uid) {
        User user = userDAO.selectById(uid);
        return user;
    }

    @Override
    public int CountByUid() {
        return 0;
    }

    @Override
    public List<User> findByUserName(String uname) {
        return null;
    }
}
