package com.hl.service;

import com.github.pagehelper.PageInfo;
import com.hl.domain.Role;

/**
 * @author hl2333
 */
public interface RoleService {
    /**
     * 查询所有的角色信息
     * @return 所有的角色信息
     * @param page
     * @param size
     */
    PageInfo<Role> findAll(Integer page, Integer size);

    /**
     * 添加角色信息
     * @param role 角色信息
     */
    void save(Role role);
}
