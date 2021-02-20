package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SidesLengthCalculatorTest {

    private final static SidesLengthCalculator SIDES_LENGTH_CALCULATOR = new SidesLengthCalculator();

    @Test
    public void testShouldCalculateSidesLengthsWhenThreePointsApplied() {
        Point firstPoint = new Point(1.0, 2.0);
        Point secondPoint = new Point(3.0, 0);
        Point thirdPoint = new Point(4.0, 4.0);

        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint));
        List<Double> expectedLengths = new ArrayList(Arrays.asList(2.8284271247461903, 4.123105625617661, 3.605551275463989));

        List<Double> actualLengths  = SIDES_LENGTH_CALCULATOR.calculateSidesLengths(points);

        Assert.assertEquals(expectedLengths, actualLengths);
    }

    @Test
    public void testShouldCalculateSidesLengthsWhenFourPointsApplied() {
        Point firstPoint = new Point(3.0, 2.0);
        Point secondPoint = new Point(5.0, 7.0);
        Point thirdPoint = new Point(1.0, 1.0);
        Point fourthPoint = new Point(2.0, 2.0);

        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        List<Double> expectedLengths = new ArrayList(Arrays.asList(5.385164807134504, 7.211102550927978, 1.4142135623730951, 1.0));

        List<Double> actualLengths = SIDES_LENGTH_CALCULATOR.calculateSidesLengths(points);

        Assert.assertEquals(expectedLengths, actualLengths);
    }
}
