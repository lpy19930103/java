package com.lpy.spring;

public class HelloDao {
    private String name;

    public HelloDao(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
