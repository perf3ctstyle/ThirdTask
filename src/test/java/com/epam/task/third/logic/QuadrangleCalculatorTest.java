package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrangleCalculatorTest {

    private static final QuadrangleCalculator quadrangleCalculator = new QuadrangleCalculator();

    @Test
    public void testShouldCalculatePerimeter() {
        Point firstPoint = new Point(2.0, 1.0);
        Point secondPoint = new Point(1.0, 2.0);
        Point thirdPoint = new Point(2.0, 3.0);
        Point fourthPoint = new Point(4.0, 3.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);
        double expectedPerimeter = 7.6568;

        double actualPerimeter = quadrangleCalculator.calculatePerimeter(quadrangle);

        Assert.assertEquals(expectedPerimeter, actualPerimeter, 0.001);
    }

    @Test
    public void testShouldCalculateArea() {
        Point firstPoint = new Point(2.0, 1.0);
        Point secondPoint = new Point(2.0, 3.0);
        Point thirdPoint = new Point(4.0, 3.0);
        Point fourthPoint = new Point(4.0, 1.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);
        double expectedArea = 4;

        double actualArea = quadrangleCalculator.calculateArea(quadrangle);

        Assert.assertEquals(expectedArea, actualArea, 0.1);
    }
}
