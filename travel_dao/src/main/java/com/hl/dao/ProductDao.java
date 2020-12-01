package com.hl.dao;

import com.hl.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hl2333
 */
@Repository
public interface ProductDao {
    /**
     * 查询所有的产品信息
     * @return 所有产品的信息
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 向数据库中添加产品信息
     * @param product 产品信息
     */
    @Insert("INSERT INTO ssm_travel.product " +
            "(productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus) " +
            "VALUES (#{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    void save(Product product);

    /**
     * 根据产品编号查询到产品的详细信息
     * @param id 产品编号
     * @return 查询到的商品信息
     */
    @Select("select * from product where id = #{id}")
    Product findById(String id);

}
