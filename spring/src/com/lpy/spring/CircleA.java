package com.lpy.spring;

public class CircleA {
    private CircleB circleB;

    public CircleA(CircleB circleB) {
        this.circleB = circleB;
    }

    public CircleB getCircleB() {
        return circleB;
    }

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }

    public void a() {
        circleB.b();
    }
}
