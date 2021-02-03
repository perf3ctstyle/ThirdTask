package com.epam.task.third.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quadrangle {

    private final List<Point> points;
    private final List<Line> sides;

    public Quadrangle(List<Point> points) {
        this.points = points;
        Line firstSide = new Line(points.get(0), points.get(1));
        Line secondSide = new Line(points.get(1), points.get(2));
        Line thirdSide = new Line(points.get(2), points.get(3));
        Line fourthSide = new Line(points.get(3), points.get(0));
        this.sides = new ArrayList(Arrays.asList(firstSide, secondSide, thirdSide, fourthSide));
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public List<Line> getSides() {
        return this.sides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Quadrangle thatQuadrangle = (Quadrangle) o;
        List<Point> thatPoints = thatQuadrangle.getPoints();
        for (int i=0; i<thatPoints.size(); i++) {
            Point thatPoint = thatPoints.get(i);
            if (!points.contains(thatPoint)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + points.hashCode();
        result = prime * result + sides.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "points=" + points.toString() +
                ", sides=" + sides.toString() +
                '}';
    }
}
