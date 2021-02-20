package com.epam.task.third.entities;

public class QuadrangleParameters {

    private final double area;
    private final double perimeter;

    public QuadrangleParameters(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return this.area;
    }

    public double getPerimeter() {
        return this.perimeter;
    }
}
