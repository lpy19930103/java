package com.lpy.mybatis.dao;

import com.lpy.mybatis.pojo.Order;
import com.lpy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    User queryOrderUserByOrderNumber(@Param("number") String number);

    Order queryOrderWithUserByOrderNumber(@Param("number") String number);

    Order queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);
}
