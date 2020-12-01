package com.hl.service;

import com.hl.domain.Product;

import java.util.List;

/**
 * @author hl2333
 */
public interface ProductService {
    /**
     * 查询信息
     * @return 所有产品信息
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;


    /**
     * 保存产品信息
     * @param product 产品信息
     */
    void save(Product product);
}
