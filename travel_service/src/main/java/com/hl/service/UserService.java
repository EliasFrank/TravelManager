package com.hl.service;

import com.github.pagehelper.PageInfo;
import com.hl.domain.UserInfo;

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
}
