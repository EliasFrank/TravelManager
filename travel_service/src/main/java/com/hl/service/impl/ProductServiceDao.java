package com.hl.service.impl;

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
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
