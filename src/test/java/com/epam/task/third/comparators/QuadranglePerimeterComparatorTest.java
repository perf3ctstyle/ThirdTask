package com.epam.task.third.comparators;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadranglePerimeterComparatorTest {

    private final QuadrangleAreaComparator quadrangleAreaComparator = new QuadrangleAreaComparator();

    @Test
    public void testShouldCompareTwoQuadranglesByPerimeterWhenFirstQuadrangleIsLesser() {
        Point firstPoint = new Point(1.0, 1.0);
        Point secondPoint = new Point(2.0, 1.0);
        Point thirdPoint = new Point(2.0, 2.0);
        Point fourthPoint = new Point(1.0, 2.0);
        List<Point> firstQuadranglePoints = new ArrayList<>(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle firstQuadrangle = new Quadrangle(firstQuadranglePoints);

        Point fifthPoint = new Point(1.0, 1.0);
        Point sixthPoint = new Point(4.0, 1.0);
        Point seventhPoint = new Point(4.0, 3.0);
        Point eighthPoint = new Point(1.0, 3.0);
        List<Point> secondQuadranglePoints = new ArrayList<>(Arrays.asList(fifthPoint, sixthPoint, seventhPoint, eighthPoint));
        Quadrangle secondQuadrangle = new Quadrangle(secondQuadranglePoints);

        int comparisonResult = quadrangleAreaComparator.compare(firstQuadrangle, secondQuadrangle);

        Assert.assertEquals(-1, comparisonResult);
    }

    @Test
    public void testShouldCompareTwoQuadranglesByPerimeterWhenFirstQuadrangleIsBigger() {
        Point firstPoint = new Point(1.0, 1.0);
        Point secondPoint = new Point(6.0, 1.0);
        Point thirdPoint = new Point(6.0, 6.0);
        Point fourthPoint = new Point(1.0, 6.0);
        List<Point> firstQuadranglePoints = new ArrayList<>(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle firstQuadrangle = new Quadrangle(firstQuadranglePoints);

        Point fifthPoint = new Point(1.0, 1.0);
        Point sixthPoint = new Point(3.0, 1.0);
        Point seventhPoint = new Point(3.0, 2.0);
        Point eighthPoint = new Point(1.0, 2.0);
        List<Point> secondQuadranglePoints = new ArrayList<>(Arrays.asList(fifthPoint, sixthPoint, seventhPoint, eighthPoint));
        Quadrangle secondQuadrangle = new Quadrangle(secondQuadranglePoints);

        int comparisonResult = quadrangleAreaComparator.compare(firstQuadrangle, secondQuadrangle);

        Assert.assertEquals(1, comparisonResult);
    }
}
