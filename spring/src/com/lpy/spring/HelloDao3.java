package com.lpy.spring;

public class HelloDao3 {
    private String name;
    private HelloDao2 helloDao2;

    public HelloDao2 getHelloDao2() {
        return helloDao2;
    }

    public void setHelloDao2(HelloDao2 helloDao2) {
        this.helloDao2 = helloDao2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
