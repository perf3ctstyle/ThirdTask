package com.epam.task.third.observer;

import com.epam.task.third.entities.Quadrangle;

public interface Observer {

    void update(QuadrangleObservable quadrangle);
}
