package com.hl.service;

import com.github.pagehelper.PageInfo;
import com.hl.domain.Role;
import com.hl.domain.UserInfo;

import java.util.List;

/**
 * @author hl2333
 */
public interface UserService {
    /**
     * 查询所有用户的信息
     * @param page 查询的页数
     * @param size 每一页多少条数据
     * @return 所有用户的信息
     */
    public PageInfo findAll(int page, int size);

    /**
     * 加密用户传入的密码
     * 然后将用户数据添加到数据库中
     * @param userInfo 用户信息
     */
    public void save(UserInfo userInfo);

    /**
     * 根据用户id查询用户的详细信息
     * @param id 用户id
     * @return 用户的详细信息
     */
    UserInfo findById(String id);

    /**
     * 根据用户id查询可添加的权限信息
     * @param id 用户id
     * @return 可添加的权限信息
     */
    List<Role> findRoles(String id);

    /**
     * 给指定id的用户添加一系列的权限
     * @param ids 权限的编号
     * @param userId 用户id
     */
    void addRole(Integer[] ids, Integer userId);
}
