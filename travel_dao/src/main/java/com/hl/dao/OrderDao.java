package com.hl.dao;

import com.hl.domain.Member;
import com.hl.domain.Order;
import com.hl.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

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

    /**
     * 根据订单编号，查询订单的详细信息
     * @param id 订单编号
     * @return 订单的详细信息
     */
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.hl.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId",
                    javaType = Member.class,
                    one = @One(select = "com.hl.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id",
                    javaType = java.util.List.class,
                    many = @Many(select = "com.hl.dao.TravellerDao.findByOrderId"))
    })
    Order findById(Integer id);
}
