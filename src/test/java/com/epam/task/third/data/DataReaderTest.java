package com.epam.task.third.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private static final String TEST_DATA = "./src/test/resources/input.txt";
    private static final String NON_EXISTENT_TEST_DATA = "doesntExist.txt";

    @Test
    public void testShouldReadDataFromExistingFile() throws DataException {
        DataReader dataReader = new DataReader(TEST_DATA);
        List<String> expected = new ArrayList();
        expected.addAll(Arrays.asList("-1.0 2.0 3.0 4.0", "2.0 3.0 1.0 2.0", "3.0z 2.0f 1.5 4.5", "3.5 2.5 1.5 2"));

        List<String> actual = dataReader.readData();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class)
    public void testShouldThrowExceptionBecauseOfNonExistentFile() throws DataException {
        DataReader dataReader = new DataReader(NON_EXISTENT_TEST_DATA);

        List<String> actual = dataReader.readData();
    }

    @Test
    public void testSecondShouldThrowExceptionBecauseOfNonExistentFile() throws DataException {
        DataReader dataReader = new DataReader(NON_EXISTENT_TEST_DATA);

        try {
            List<String> actual = dataReader.readData();
            Assert.fail("Expected DataException!");
        } catch (DataException e) {
            Assert.assertEquals("The file hasn't been found!", e.getMessage());
        }
    }
}
