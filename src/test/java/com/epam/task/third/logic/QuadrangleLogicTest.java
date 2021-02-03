package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrangleLogicTest {

    private static final QuadrangleLogic quadrangleLogic = new QuadrangleLogic();

    @Test
    public void testShouldCalculatePerimeter() {
        Point firstPoint = new Point(2.0, 1.0);
        Point secondPoint = new Point(1.0, 2.0);
        Point thirdPoint = new Point(2.0, 3.0);
        Point fourthPoint = new Point(4.0, 3.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);
        double expectedPerimeter = 7.6568;

        double actualPerimeter = quadrangleLogic.calculatePerimeter(quadrangle);

        Assert.assertEquals(expectedPerimeter, actualPerimeter, 0.001);
    }

    @Test
    public void testPositiveShouldCheckIfQuadrangleIsSquare() {
        Point firstPoint = new Point(2.0, 1.0);
        Point secondPoint = new Point(2.0, 3.0);
        Point thirdPoint = new Point(4.0, 3.0);
        Point fourthPoint = new Point(4.0, 1.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);

        boolean result = quadrangleLogic.isSquare(quadrangle);

        Assert.assertTrue(result);
    }

    @Test
    public void testNegativeShouldCheckIfQuadrangleIsSquare() {
        Point firstPoint = new Point(1.0, 2.0);
        Point secondPoint = new Point(3.0, 4.0);
        Point thirdPoint = new Point(5.0, 6.0);
        Point fourthPoint = new Point(7.0, 8.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);

        boolean result = quadrangleLogic.isSquare(quadrangle);

        Assert.assertFalse(result);
    }

    @Test
    public void testFirstNegativeShouldCheckIfQuadrangleIsQuadrangle() {
        Point firstPoint = new Point(1.0, 1.0);
        Point secondPoint = new Point(2.0, 2.0);
        Point thirdPoint = new Point(3.0, 3.0);
        Point fourthPoint = new Point(4.0, 4.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);

        boolean result = quadrangleLogic.isQuadrangle(quadrangle);

        Assert.assertFalse(result);
    }

    @Test
    public void testSecondNegativeShouldCheckIfQuadrangleIsQuadrangle() {
        Point firstPoint = new Point(1.0, 2.0);
        Point secondPoint = new Point(2.0, 2.0);
        Point thirdPoint = new Point(3.0, 3.0);
        Point fourthPoint = new Point(4.0, 4.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);

        boolean result = quadrangleLogic.isQuadrangle(quadrangle);

        Assert.assertFalse(result);
    }

    @Test
    public void testThirdNegativeShouldCheckIfQuadrangleIsQuadrangle() {
        Point firstPoint = new Point(2.0, 1.0);
        Point secondPoint = new Point(1.0, 2.0);
        Point thirdPoint = new Point(5.0, 6.0);
        Point fourthPoint = new Point(7.0, 8.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);

        boolean result = quadrangleLogic.isQuadrangle(quadrangle);

        Assert.assertFalse(result);
    }

    @Test
    public void testPositiveShouldCheckIfQuadrangleIsQuadrangle() {
        Point firstPoint = new Point(1.0, 1.0);
        Point secondPoint = new Point(4.0, 1.0);
        Point thirdPoint = new Point(4.0, 3.0);
        Point fourthPoint = new Point(1.0, 3.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle quadrangle = new Quadrangle(points);

        boolean result = quadrangleLogic.isQuadrangle(quadrangle);

        Assert.assertTrue(result);
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

        double actualArea = quadrangleLogic.calculateArea(quadrangle);

        Assert.assertEquals(expectedArea, actualArea, 0.1);
    }
}
