package com.hl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.dao.PermissionDao;
import com.hl.domain.Permission;
import com.hl.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hl2333
 */

@Service
@Transactional(rollbackFor = {})
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public void deleteById(String id) {
        permissionDao.delete(id);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public PageInfo<Permission> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Permission> permissions = permissionDao.findAll();
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);
        return pageInfo;

    }
}
