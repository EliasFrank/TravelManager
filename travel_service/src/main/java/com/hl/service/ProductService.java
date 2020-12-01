package com.hl.service;

import com.github.pagehelper.PageInfo;
import com.hl.domain.Product;

/**
 * @author hl2333
 */
public interface ProductService {
    /**
     * 查询信息
     * @return 所有产品信息
     * @throws Exception
     * @param page
     * @param size
     */
    public PageInfo<Product> findAll(Integer page, Integer size) throws Exception;


    /**
     * 保存产品信息
     * @param product 产品信息
     */
    void save(Product product);
}
