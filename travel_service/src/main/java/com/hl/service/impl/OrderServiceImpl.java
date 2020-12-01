package com.hl.service.impl;

import com.hl.dao.OrderDao;
import com.hl.domain.Order;
import com.hl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hl2333
 */
@Service
@Transactional(rollbackFor = {})
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        List<Order> all = orderDao.findAll();
        return all;
    }
}
