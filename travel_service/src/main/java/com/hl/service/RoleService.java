package com.hl.service;

import com.github.pagehelper.PageInfo;
import com.hl.domain.Permission;
import com.hl.domain.Role;

import java.util.List;

/**
 * @author hl2333
 */
public interface RoleService {

    /**
     * 根据角色信息查询出可以添加的权限
     * @param id 角色id
     * @return 权限
     */
    List<Permission> findPermissions(String id);
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

    /**
     * 根据用户id查询所有的权限
     * @param id 角色id
     * @return 查询角色所具有的全部权限
     */
    Role findById(String id);

    /**
     * 根据用户id删除用户
     * @param id 用户id
     */
    void deleteRole(String id);

    /**
     * 给角色添加权限
     * @param ids 需要添加的权限
     * @param roleId 角色id
     */
    void addPermission(String[] ids, String roleId);
}
