package com.hl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.dao.RoleDao;
import com.hl.domain.Role;
import com.hl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hl2333
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public PageInfo<Role> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Role> result = roleDao.findAll();
        PageInfo<Role> roles = new PageInfo<>(result);
        return roles;
    }
}
