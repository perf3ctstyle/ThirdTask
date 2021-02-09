package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleCalculator {

    private final static SidesLengthCalculator SIDES_LENGTH_CALCULATOR = new SidesLengthCalculator();

    private final static Logger LOGGER = LogManager.getLogger(QuadrangleCalculator.class);

    public double calculatePerimeter(Quadrangle quadrangle) {
        LOGGER.info("Method calculatePerimeter for quadrangle " + quadrangle.toString() + " started.");
        List<Point> quadranglePoints = quadrangle.getPoints();
        List<Double> sidesLengths = SIDES_LENGTH_CALCULATOR.calculateSidesLengths(quadranglePoints);
        double perimeter = 0;
        for (int i = 0; i < sidesLengths.size(); i++) {
            double currentSideLength = sidesLengths.get(i);
            perimeter += currentSideLength;
        }
        LOGGER.info("Method calculatePerimeter finished. Calculated perimeter: " + perimeter);
        return perimeter;
    }

    public double calculateArea(Quadrangle quadrangle) {
        LOGGER.info("Method calculateArea for quadrangle " + quadrangle.toString() + " started.");
        double area = 1;
        double halfPerimeter = calculatePerimeter(quadrangle) / 2;
        List<Point> quadranglePoints = quadrangle.getPoints();
        List<Double> sidesLengths = SIDES_LENGTH_CALCULATOR.calculateSidesLengths(quadranglePoints);
        for (int i = 0; i < sidesLengths.size(); i++) {
            double currentSideLength = sidesLengths.get(i);
            area *= halfPerimeter - currentSideLength;
        }
        area = Math.sqrt(area);
        LOGGER.info("Method calculateArea finished. Calculated area: " + area);
        return area;
    }
}
