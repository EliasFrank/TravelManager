package com.hl.service;

import com.hl.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hl2333
 */

public interface OrderService {
    /**
     * 调用dao接口的findAll方法，查询所有的订单信息
     * @return 查询到的所有订单信息
     */
    List<Order> findAll();
}
