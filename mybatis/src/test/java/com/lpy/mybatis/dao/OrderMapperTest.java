package com.lpy.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    private OrderMapper mapper;

    @BeforeEach
    void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    void queryOrderUserByOrderNumber() {
        System.out.println(mapper.queryOrderUserByOrderNumber("123").toString());
    }


    @Test
    void queryOrderWithUserByOrderNumber() {
        System.out.println(mapper.queryOrderWithUserByOrderNumber("123").toString());
    }

    @Test
    void queryOrderWithUserAndDetailByOrderNumber() {
        System.out.println(mapper.queryOrderWithUserAndDetailByOrderNumber("123").getUser().toString());
        System.out.println(mapper.queryOrderWithUserAndDetailByOrderNumber("123").getDetailList().toString());
    }

    @Test
    void queryOrderWithUserAndDetailItemByOrderNumber() {
        System.out.println(mapper.queryOrderWithUserAndDetailItemByOrderNumber("123").getUser().toString());
        System.out.println(mapper.queryOrderWithUserAndDetailItemByOrderNumber("123").getDetailList().toString());
        System.out.println(mapper.queryOrderWithUserAndDetailItemByOrderNumber("123").getDetailList().get(0).getItem().toString());

    }
}