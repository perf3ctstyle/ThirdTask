package com.epam.task.third.specifications;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrangleSpecificationByPerimeterTest {

    private final static double MIN_PERIMETER_FOR_FIRST_TEST = 5;
    private final static double MAX_PERIMETER_FOR_FIRST_TEST = 25;

    private final static double MIN_PERIMETER_FOR_SECOND_TEST = 10;
    private final static double MAX_PERIMETER_FOR_SECOND_TEST = 20;

    private QuadrangleSpecificationByPerimeter quadrangleSpecificationByPerimeter;

    @Test
    public void testShouldSpecifyQuadrangleByPerimeterWhenAreaIsBetweenMinAndMax() {
        quadrangleSpecificationByPerimeter = new QuadrangleSpecificationByPerimeter(MIN_PERIMETER_FOR_FIRST_TEST, MAX_PERIMETER_FOR_FIRST_TEST);
        Point firstPoint = new Point(1.0, 1.0);
        Point secondPoint = new Point(4.0, 1.0);
        Point thirdPoint = new Point(4.0, 3.0);
        Point fourthPoint = new Point(1.0, 3.0);
        List<Point> points = new ArrayList<>(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);

        boolean isSpecified = quadrangleSpecificationByPerimeter.isSpecified(quadrangle);

        Assert.assertTrue(isSpecified);
    }

    @Test
    public void testShouldSpecifyQuadrangleByPerimeterWhenPerimeterIsNotBetweenMinAndMax() {
        quadrangleSpecificationByPerimeter = new QuadrangleSpecificationByPerimeter(MIN_PERIMETER_FOR_SECOND_TEST, MAX_PERIMETER_FOR_SECOND_TEST);
        Point firstPoint = new Point(1.0, 1.0);
        Point secondPoint = new Point(2.0, 1.0);
        Point thirdPoint = new Point(2.0, 2.0);
        Point fourthPoint = new Point(1.0, 2.0);
        List<Point> points = new ArrayList<>(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);

        boolean isSpecified = quadrangleSpecificationByPerimeter.isSpecified(quadrangle);

        Assert.assertFalse(isSpecified);
    }
}
