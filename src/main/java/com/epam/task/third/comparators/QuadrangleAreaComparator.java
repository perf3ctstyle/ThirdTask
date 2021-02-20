package com.epam.task.third.comparators;

import com.epam.task.third.entities.Quadrangle;
import com.epam.task.third.logic.QuadrangleCalculator;

import java.util.Comparator;

public class QuadrangleAreaComparator implements Comparator<Quadrangle> {

    private final QuadrangleCalculator quadrangleCalculator = new QuadrangleCalculator();

    public int compare(Quadrangle firstQuadrangle, Quadrangle secondQuadrangle) {
        double firstQuadrangleArea = quadrangleCalculator.calculateArea(firstQuadrangle);
        double secondQuadrangleArea = quadrangleCalculator.calculateArea(secondQuadrangle);
        return Double.compare(firstQuadrangleArea, secondQuadrangleArea);
    }
}
