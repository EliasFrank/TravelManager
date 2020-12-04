package com.hl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.dao.UserDao;
import com.hl.domain.UserInfo;
import com.hl.service.UserService;
import com.hl.utils.EncodePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hl2333
 */
@Service
@Transactional(rollbackFor = {})
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(
                EncodePassword.encodePassword(
                        userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public PageInfo findAll(int page, int size) {
        PageHelper.startPage(page, size);
        List<UserInfo> users = userDao.findAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
