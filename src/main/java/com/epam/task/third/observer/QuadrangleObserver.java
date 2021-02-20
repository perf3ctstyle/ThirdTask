package com.epam.task.third.observer;

import com.epam.task.third.entities.QuadrangleParameters;
import com.epam.task.third.logic.QuadrangleCalculator;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleObserver implements Observer {

    private static QuadrangleObserver instance;

    private final QuadrangleCalculator quadrangleCalculator;
    private final Map<Integer, QuadrangleParameters> parameters;

    private QuadrangleObserver() {
        quadrangleCalculator = new QuadrangleCalculator();
        parameters = new HashMap<>();
    }

    public static QuadrangleObserver getInstance() {
        if (instance == null) {
            instance = new QuadrangleObserver();
        }
        return instance;
    }

    @Override
    public void update(QuadrangleObservable quadrangleObservable) {
        QuadrangleParameters quadrangleParameters = calculateQuadrangleParameters(quadrangleObservable);
        int quadrangleObservableId = quadrangleObservable.getId();
        parameters.put(quadrangleObservableId, quadrangleParameters);
    }

    private QuadrangleParameters calculateQuadrangleParameters(QuadrangleObservable quadrangleObservable) {
        double area = quadrangleCalculator.calculateArea(quadrangleObservable);
        double perimeter = quadrangleCalculator.calculatePerimeter(quadrangleObservable);
        return new QuadrangleParameters(area, perimeter);
    }
}
