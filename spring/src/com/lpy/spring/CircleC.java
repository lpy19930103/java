package com.lpy.spring;

public class CircleC {
    private CircleA circleA;

    public CircleC(CircleA circleA) {
        this.circleA = circleA;
    }

    public CircleA getCircleA() {
        return circleA;
    }

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }

    public void c() {
        circleA.a();
    }
}
