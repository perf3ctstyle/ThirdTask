package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SidesLengthCalculator {

    private final static Logger LOGGER = LogManager.getLogger(SidesLengthCalculator.class);

    private double calculateLineLength(Point firstPoint, Point secondPoint) {
        LOGGER.info("Method calculateLineLength started.");
        double firstPointX = firstPoint.getX();
        double firstPointY = firstPoint.getY();
        double secondPointX = secondPoint.getX();
        double secondPointY = secondPoint.getY();
        double length = Math.sqrt((secondPointX - firstPointX) * (secondPointX - firstPointX)
                + (secondPointY - firstPointY) * (secondPointY - firstPointY));
        LOGGER.info("Method calculateLineLength finished. Length: " + length);
        return length;
    }

    public List<Double> calculateSidesLengths(List<Point> points) {
        LOGGER.info("Method calculateLinesLengths started.");
        List<Double> linesLengths = new ArrayList();
        for (int i=1; i<points.size(); i++) {
            Point fromPoint = points.get(i-1);
            Point toPoint = points.get(i);
            double lineLength = calculateLineLength(fromPoint, toPoint);
            linesLengths.add(lineLength);
        }
        int lastPointIndex = points.size()-1;
        Point fromLastPoint = points.get(lastPointIndex);
        Point toFirstPoint = points.get(0);
        double lastLineLength = calculateLineLength(fromLastPoint, toFirstPoint);
        linesLengths.add(lastLineLength);
        LOGGER.info("Method calculateLinesLengths finished.");
        return linesLengths;
    }
}
