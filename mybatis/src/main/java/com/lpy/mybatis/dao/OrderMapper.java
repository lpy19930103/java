package com.lpy.mybatis.dao;

import com.lpy.mybatis.pojo.Order;
import com.lpy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    //根据订单号查询订单用户的信息
    User queryOrderUserByOrderNumber(@Param("number") String number);

    //根据订单号查询订单用户的信息
    Order queryOrderWithUserByOrderNumber(@Param("number") String number);

    Order queryOrderWithUserByOrderNumberLazy(@Param("number") String number);

    //根据订单号查询订单用户的信息及订单详情
    Order queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);

    //根据订单号查询订单用户的信息及订单详情及订单详情对应的商品信息
    Order queryOrderWithUserAndDetailItemByOrderNumber(@Param("number") String number);

}
