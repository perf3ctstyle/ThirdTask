package com.epam.task.third.entities;

import com.epam.task.third.logic.IdGenerator;

import java.util.List;

public class Quadrangle {

    private List<Point> points;
    private int id;

    public Quadrangle(List<Point> points) {
        this.points = points;
        IdGenerator idGenerator = new IdGenerator();
        this.id = idGenerator.generateId();
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
        for (int i = 0; i < thatPoints.size(); i++) {
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
        return result;
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "points=" + points.toString() +
                '}';
    }
}
