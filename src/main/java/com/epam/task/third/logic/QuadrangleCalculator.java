package com.epam.task.third.logic;

import com.epam.task.third.entities.Line;
import com.epam.task.third.entities.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleCalculator {

    private final static Logger LOGGER = LogManager.getLogger(QuadrangleCalculator.class);

    public double calculatePerimeter(Quadrangle quadrangle) {
        LOGGER.info("Method calculatePerimeter for quadrangle " + quadrangle.toString() + " started.");
        List<Line> sides = quadrangle.getSides();
        double perimeter = 0;
        for (int i=0; i<sides.size(); i++) {
            Line currentSide = sides.get(i);
            double currentSideLength = currentSide.getLength();
            perimeter += currentSideLength;
        }
        LOGGER.info("Method calculatePerimeter finished. Calculated perimeter: " + perimeter);
        return perimeter;
    }

    public double calculateArea(Quadrangle quadrangle) {
        LOGGER.info("Method calculateArea for quadrangle " + quadrangle.toString() + " started.");
        double area = 1;
        double halfPerimeter = calculatePerimeter(quadrangle) / 2;
        List<Line> quadrangleSides = quadrangle.getSides();
        for (int i=0; i<quadrangleSides.size(); i++) {
            Line currentSide = quadrangleSides.get(i);
            double currentSideLength = currentSide.getLength();
            area *= halfPerimeter - currentSideLength;
        }
        area = Math.sqrt(area);
        LOGGER.info("Method calculateArea finished. Calculated area: " + area);
        return area;
    }
}
