package com.epam.task.third.entities;

public class Line {

    private final Point firstPoint;
    private final Point secondPoint;
    private final double length;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        double firstPointX = firstPoint.getX();
        double firstPointY = firstPoint.getY();
        double secondPointX = secondPoint.getX();
        double secondPointY = secondPoint.getY();
        this.length = Math.sqrt((secondPointX - firstPointX) * (secondPointX - firstPointX)
                + (secondPointY - firstPointY) * (secondPointY - firstPointY));
    }

    public double getLength() {
        return this.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Double.compare(line.length, length) == 0 && firstPoint.equals(line.firstPoint) && secondPoint.equals(line.secondPoint);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + firstPoint.hashCode();
        result = prime * result + secondPoint.hashCode();
        result = prime * result + (int)getLength();
        return result;
    }

    @Override
    public String toString() {
        return "Line {" +
                "firstPoint=" + firstPoint.toString() +
                ", secondPoint=" + secondPoint.toString() +
                ", length=" + length +
                '}';
    }
}
