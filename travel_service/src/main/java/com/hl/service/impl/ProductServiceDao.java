package com.hl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.dao.ProductDao;
import com.hl.domain.Product;
import com.hl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = {})
public class ProductServiceDao implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public PageInfo<Product> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<Product> all = productDao.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
