package com.lpy.spring;

public class HelloDao5 {
    private String name;
    private HelloDao4 helloDao4;

    public HelloDao4 getHelloDao4() {
        return helloDao4;
    }

    public void setHelloDao4(HelloDao4 helloDao4) {
        this.helloDao4 = helloDao4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
