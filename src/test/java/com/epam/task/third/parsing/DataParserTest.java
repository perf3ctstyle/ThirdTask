package com.epam.task.third.parsing;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParserTest {

    DataParser dataParser = new DataParser();

    @Test
    public void testShouldCreateQuadrangleWhenDataIsCorrect() {
        String data = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0";
        Point firstPoint = new Point(1.0, 2.0);
        Point secondPoint = new Point(3.0, 4.0);
        Point thirdPoint = new Point(5.0, 6.0);
        Point fourthPoint = new Point(7.0, 8.0);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle expected = new Quadrangle(points);

        Quadrangle actual = dataParser.createQuadrangle(data);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSecondShouldCreateQuadrangleWhenDataIsCorrect() {
        String data = "1.2331 2.3123 2.55555 1.313 4.556789 1.3131 5 6";
        Point firstPoint = new Point(1.2331, 2.3123);
        Point secondPoint = new Point(2.55555, 1.313);
        Point thirdPoint = new Point(4.556789, 1.3131);
        Point fourthPoint = new Point(5, 6);
        List<Point> points = new ArrayList(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        Quadrangle expected = new Quadrangle(points);

        Quadrangle actual = dataParser.createQuadrangle(data);

        Assert.assertEquals(expected, actual);
    }
}
