package com.epam.task.third.parsing;

import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private final static Logger LOGGER = LogManager.getLogger(DataParser.class);

    private static final String WHITESPACE_CHARACTER = "\s";

    public Quadrangle createQuadrangle(String data) {
        LOGGER.info("Method createQuadrangle from the following data: " + data + " started.");
        String[] coordinates = data.split(WHITESPACE_CHARACTER);
        List<Point> points = new ArrayList();
        for (int i = 0; i < coordinates.length; i=i+2) {
            double x = Double.parseDouble(coordinates[i]);
            double y = Double.parseDouble(coordinates[i + 1]);
            Point point = new Point(x, y);
            points.add(point);
        }
        Quadrangle quadrangle = new Quadrangle(points);
        LOGGER.info("Method createQuadrangle from the following data: " + data + " finished. Quadrangle has been created successfully.");
        return quadrangle;
    }
}
