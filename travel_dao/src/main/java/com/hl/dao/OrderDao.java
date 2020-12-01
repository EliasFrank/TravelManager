package com.hl.dao;

import com.hl.domain.Order;
import com.hl.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hl2333
 */
public interface OrderDao {
    /**
     * 查询所有的订单
     * @return 所有的订单信息
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true,  property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.hl.dao.ProductDao.findById"))
    })
    List<Order> findAll();
}
