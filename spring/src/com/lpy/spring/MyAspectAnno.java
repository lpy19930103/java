package com.lpy.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnno {
    @Before("MyAspectAnno.pointcut1()")
    public void before() {
        System.out.println("前置通知======");
    }

    @AfterReturning("MyAspectAnno.pointcut2()")
    public void afterReturning() {
        System.out.println("后置通知======");
    }

    @Around("MyAspectAnno.pointcut3()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知======");
        String proceed = (String) joinPoint.proceed();
        System.out.println("环绕后通知======"+proceed);
        return proceed;
    }

    @AfterThrowing("MyAspectAnno.pointcut4()")
    public void afterThrowing() {
        System.out.println("异常抛出通知======");
    }

    @After("MyAspectAnno.pointcut4()")
    public void after() {
        System.out.println("最终通知======");
    }


    @Pointcut("execution(* com.lpy.spring.ProductDao.save(..))")
    private void pointcut1() {

    }

    @Pointcut("execution(* com.lpy.spring.ProductDao.update(..))")
    private void pointcut2() {

    }

    @Pointcut("execution(* com.lpy.spring.ProductDao.delete(..))")
    private void pointcut3() {

    }

    @Pointcut("execution(* com.lpy.spring.ProductDao.find(..))")
    private void pointcut4() {

    }
}
