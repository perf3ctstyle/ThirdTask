package com.epam.task.third.observer;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleObservable extends Quadrangle implements Observable {

    private final List<Observer> observers;

    public QuadrangleObservable(List<Point> points) {
        super(points);
        this.observers = new ArrayList<>();
    }

    @Override
    public void setPoints(List<Point> points) {
        super.setPoints(points);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
