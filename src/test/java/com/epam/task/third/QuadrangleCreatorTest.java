package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Quadrangle;
import com.epam.task.third.parsing.DataParser;
import com.epam.task.third.parsing.DataValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class QuadrangleCreatorTest {

    private final DataReader dataReader = Mockito.mock(DataReader.class);
    private final DataParser dataParser = Mockito.mock(DataParser.class);
    private final DataValidator dataValidator = Mockito.mock(DataValidator.class);

    private final QuadrangleCreator quadrangleCreator = new QuadrangleCreator(dataReader, dataParser, dataValidator);

    private final static String FIRST_TEST_DATA_LINE = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0";
    private final static String SECOND_TEST_DATA_LINE = "2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0";
    private final static List<String> TEST_INPUT = Arrays.asList(FIRST_TEST_DATA_LINE, SECOND_TEST_DATA_LINE);

    @Test
    public void testShouldCreateTwoQuadrangles() throws DataException {
        when(dataReader.readData()).thenReturn(TEST_INPUT);
        when (dataValidator.validate(anyString())).thenReturn(true);

        Point firstPoint = new Point(1.0, 2.0);
        Point secondPoint = new Point(3.0, 4.0);
        Point thirdPoint = new Point(5.0, 6.0);
        Point fourthPoint = new Point(7.0, 8.0);
        Quadrangle firstQuadrangle = new Quadrangle(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));

        Point fifthPoint = new Point(2.0, 3.0);
        Point sixthPoint = new Point(4.0, 5.0);
        Point seventhPoint = new Point(6.0, 7.0);
        Point eigthPoint = new Point(8.0, 9.0);
        Quadrangle secondQuadrangle = new Quadrangle(Arrays.asList(fifthPoint, sixthPoint, seventhPoint, eigthPoint));

        when(dataParser.createQuadrangle(FIRST_TEST_DATA_LINE)).thenReturn(firstQuadrangle);
        when(dataParser.createQuadrangle(SECOND_TEST_DATA_LINE)).thenReturn(secondQuadrangle);

        List<Quadrangle> expectedQuadrangles = new ArrayList();
        expectedQuadrangles.add(firstQuadrangle);
        expectedQuadrangles.add(secondQuadrangle);

        List<Quadrangle> actualQuadrangles = quadrangleCreator.process();

        Assert.assertEquals(expectedQuadrangles, actualQuadrangles);
    }
}
