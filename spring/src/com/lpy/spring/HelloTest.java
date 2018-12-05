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
        HelloApi hello = context.getBean("demo", HelloApi.class);
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

    @Test
    public void testUser() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        UserDao user = context.getBean("user", UserDao.class);
        user.sayHello();
    }

    @Test
    public void testHello2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hello.xml", "user.xml");
        System.out.println("--------hello---------");
        HelloDao hello = context.getBean("hello", HelloDao.class);
        System.out.println(hello.getName());
        System.out.println("--------hello2---------");
        HelloDao2 hello2 = context.getBean("hello2", HelloDao2.class);
        System.out.println(hello2.getName());
        System.out.println("--------hello3---------");
        HelloDao3 hello3 = context.getBean("hello3", HelloDao3.class);
        System.out.println(hello3.getName());
        System.out.println(hello3.getHelloDao2().getName());

        System.out.println("--------hello4---------");
        HelloDao4 hello4 = context.getBean("hello4", HelloDao4.class);
        System.out.println(hello4.getName());
        System.out.println(hello4.getHelloDao3().getName());

        System.out.println("--------hello5---------");
        HelloDao5 hello5 = context.getBean("hello5", HelloDao5.class);
        System.out.println(hello5.getName());
        System.out.println(hello5.getHelloDao4().getName());
        System.out.println("--------hello6---------");
        HelloDao6 hello6 = context.getBean("hello6", HelloDao6.class);
        System.out.println(hello6.toString());

        System.out.println("--------import---------");
        HelloImpl demo = context.getBean("demo", HelloImpl.class);
        demo.sayHello();

        System.out.println("--------加载多个配置---------");
        UserDao user = context.getBean("user", UserDao.class);
        user.sayHello();
    }


}
