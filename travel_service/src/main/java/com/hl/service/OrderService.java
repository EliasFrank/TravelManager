package com.hl.service;

import com.github.pagehelper.PageInfo;
import com.hl.domain.Order;

/**
 * @author hl2333
 */

public interface OrderService {
    /**
     * 调用dao接口的findAll方法，查询所有的订单信息
     * @return 查询到的所有订单信息
     * @param page
     * @param size
     */
    PageInfo<Order> findAll(Integer page, Integer size);

    /**
     * 根据订单编号查询订单详情
     * @param id 订单编号
     * @return 返回订单的详细信息
     */
    Order findById(Integer id);
}
