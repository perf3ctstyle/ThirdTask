package com.epam.task.third.specifications;

import com.epam.task.third.entities.Quadrangle;
import com.epam.task.third.logic.QuadrangleCalculator;

public class QuadrangleSpecificationByPerimeter implements QuadrangleSpecification {

    private final double minPerimeter;
    private final double maxPerimeter;
    private final QuadrangleCalculator quadrangleCalculator;

    public QuadrangleSpecificationByPerimeter(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
        this.quadrangleCalculator = new QuadrangleCalculator();
    }

    @Override
    public boolean isSpecified(Quadrangle quadrangle) {
        double perimeter = quadrangleCalculator.calculatePerimeter(quadrangle);
        return (perimeter >= minPerimeter && perimeter <= maxPerimeter);
    }
}
