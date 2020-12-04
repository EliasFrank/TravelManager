package com.hl.service;

import com.github.pagehelper.PageInfo;

/**
 * @author hl2333
 */
public interface UserService {
    /**
     * 查询所有用户的信息
     * @return 所有用户的信息
     */
    public PageInfo findAll(int page, int size);
}
