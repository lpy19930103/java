package com.lpy.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aopdemo.xml")
public class TestDemo {
    @Resource(name = "product")
    private ProductDao productDao;

    @Test
    public void testProduct() {
        productDao.save();
        productDao.update();
        productDao.delete();
        productDao.find();


    }
}
