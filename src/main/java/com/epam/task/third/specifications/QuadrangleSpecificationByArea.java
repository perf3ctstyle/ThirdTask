package com.epam.task.third.specifications;

import com.epam.task.third.entities.Quadrangle;
import com.epam.task.third.logic.QuadrangleCalculator;

public class QuadrangleSpecificationByArea implements QuadrangleSpecification {

    private final double minArea;
    private final double maxArea;
    private final QuadrangleCalculator quadrangleCalculator;

    public QuadrangleSpecificationByArea(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        quadrangleCalculator = new QuadrangleCalculator();
    }

    @Override
    public boolean isSpecified(Quadrangle quadrangle) {
        double area = quadrangleCalculator.calculateArea(quadrangle);
        return (area >= minArea && area <= maxArea);
    }
}
