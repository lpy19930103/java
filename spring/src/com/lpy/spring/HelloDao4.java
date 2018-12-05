package com.lpy.spring;

public class HelloDao4 {
    private String name;
    private HelloDao3 helloDao3;

    public HelloDao3 getHelloDao3() {
        return helloDao3;
    }

    public void setHelloDao3(HelloDao3 helloDao3) {
        this.helloDao3 = helloDao3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHello5Name() {
        return "钱七";
    }
}
