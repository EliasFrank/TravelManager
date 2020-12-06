package com.hl.dao;

import com.hl.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hl2333
 */
@Repository
public interface TravellerDao {

    /***
     * 通过订单的id，查询要出游的所有旅客的信息
     * @param id 订单编号
     * @return 所有旅客信息
     */
    @Select("select * from traveller where id in " +
            "(select travellerId from order_traveller where orderId = #{id})")
    List<Traveller> findByOrderId(int id);
}
