package com.epam.task.third.comparators;

import com.epam.task.third.entities.Quadrangle;
import com.epam.task.third.logic.QuadrangleCalculator;

import java.util.Comparator;

public class QuadranglePerimeterComparator implements Comparator<Quadrangle> {

    private final QuadrangleCalculator quadrangleCalculator = new QuadrangleCalculator();

    public int compare(Quadrangle firstQuadrangle, Quadrangle secondQuadrangle) {
        double firstQuadranglePerimeter = quadrangleCalculator.calculatePerimeter(firstQuadrangle);
        double secondQuadranglePerimeter = quadrangleCalculator.calculatePerimeter(secondQuadrangle);
        return Double.compare(firstQuadranglePerimeter, secondQuadranglePerimeter);
    }
}
