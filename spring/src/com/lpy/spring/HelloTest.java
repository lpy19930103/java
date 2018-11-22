package com.lpy.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
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

    @Test
    public void testNavigationBeanInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("navigationBeanInject.xml");
        NavigationA navigationA = context.getBean("a", NavigationA.class);
        navigationA.getNavigationB().getNavigationC().sayNavigation();
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable {
        try {
            new ClassPathXmlApplicationContext("chapter3/circleInjectByConstructor.xml");
        } catch (Exception e) {
            //因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }


}
