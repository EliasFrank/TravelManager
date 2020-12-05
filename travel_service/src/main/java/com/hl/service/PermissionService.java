package com.hl.service;

import com.github.pagehelper.PageInfo;
import com.hl.domain.Permission;

/**
 * @author hl2333
 */
public interface PermissionService {
    /**
     * 根据权限id删除权限
     * @param id 权限id
     */
    public void deleteById(String id);
    /**
     * 根据权限id查询详细信息
     * @param id 权限id
     * @return 权限的详细信息
     */
    Permission findById(String id);
    /**
     * 查询所有的权限信息
     * @return 所有的权限信息
     * @param page 第几页
     * @param size 一页多少条数据
     */
    PageInfo<Permission> findAll(Integer page, Integer size);

    /**
     * 添加权限信息
     * @param permission 权限信息
     */
    void save(Permission permission);
}
