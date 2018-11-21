package com.lpy.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

//    public static void main(String[] args) {
//        testHello();
//    }

    @Test
    public void testHello() {
        ApplicationContext context = new ClassPathXmlApplicationContext("helloworld.xml");
        HelloImpl hello = context.getBean("demo", HelloImpl.class);
        hello.sayHello();
    }


}
