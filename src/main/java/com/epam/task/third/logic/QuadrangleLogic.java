package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleLogic {

    private final static SidesLengthCalculator sidesLengthCalculator = new SidesLengthCalculator();

    private final static Logger LOGGER = LogManager.getLogger(QuadrangleLogic.class);

    public boolean isSquare(Quadrangle quadrangle) {
        LOGGER.info("Method isSquare for quadrangle " + quadrangle.toString() + " started.");
        List<Point> quadranglePoints = quadrangle.getPoints();
        List<Double> sidesLengths = sidesLengthCalculator.calculateSidesLengths(quadranglePoints);
        double sideLength = sidesLengths.get(0);
        for (int i=0; i<sidesLengths.size(); i++) {
            double currentSideLength = sidesLengths.get(i);
            if (currentSideLength != sideLength) {
                LOGGER.info("Method isSquare finished. Result: false");
                return false;
            }
        }
        LOGGER.info("Method isSquare finished. Result: true");
        return true;
    }

    private boolean ArePointsOnOneLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x3 * (y2 - y1) - y3 * (x2 - x1) == x1 * y2 - x2 * y1);
    }

    public boolean isQuadrangle(Quadrangle quadrangle) {
        LOGGER.info("Method isQuadrangle for quadrangle " + quadrangle.toString() + " started.");
        List<Point> points = quadrangle.getPoints();
        Point firstPoint = points.get(0);
        double x1 = firstPoint.getX();
        double y1 = firstPoint.getY();

        Point secondPoint = points.get(1);
        double x2 = secondPoint.getX();
        double y2 = secondPoint.getY();

        Point thirdPoint = points.get(2);
        double x3 = thirdPoint.getX();
        double y3 = thirdPoint.getY();

        Point fourthPoint = points.get(3);
        double x4 = fourthPoint.getX();
        double y4 = fourthPoint.getY();

        if (ArePointsOnOneLine(x2, y2, x3, y3, x4, y4) ||
                ArePointsOnOneLine(x1, y1, x3, y3, x4, y4) ||
                ArePointsOnOneLine(x1, y1, x2, y2, x4, y4) ||
                ArePointsOnOneLine(x1, y1, x2, y2, x3, y3)) {
            LOGGER.info("Method isQuadrangle finished. Result: false");
            return false;
        }
        LOGGER.info("Method isQuadrangle finished. Result: true");
        return true;
    }
}
