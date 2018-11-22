package com.lpy.spring;

public class CircleB {
    private CircleC circleC;

    public CircleB(CircleC circleC) {
        this.circleC = circleC;
    }

    public CircleC getCircleC() {
        return circleC;
    }

    public void setCircleC(CircleC circleC) {
        this.circleC = circleC;
    }

    public void b() {
        circleC.c();
    }
}
