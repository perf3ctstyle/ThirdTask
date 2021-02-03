package com.epam.task.third.parsing;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {

    private static final DataValidator dataValidator = new DataValidator();

    @Test
    public void testShouldValidateDataWhenDataIsCorrect() {
        String data = "1.0 2.0 2.0 3.0 3.0 4.0 5.0 6.0";

        boolean result = dataValidator.validate(data);

        Assert.assertTrue(result);
    }

    @Test
    public void testShouldValidateDataWhenDataHasComplexNumbers() {
        String data = "1.251231 3.33333 512.1 4511.2 1.032032032 2.33333 444.3 512.3";

        boolean result = dataValidator.validate(data);

        Assert.assertTrue(result);
    }

    @Test
    public void testShouldValidateDataWhenDataHasNegativeNumbers() {
        String data = "255.2 -123.1 2.5 -3.0";

        boolean result = dataValidator.validate(data);

        Assert.assertFalse(result);
    }

    @Test
    public void testShouldValidateDataWhenDataIsnotCorrect() {
        String data = "1.0 2.555 1.2f3 123.5";

        boolean result = dataValidator.validate(data);

        Assert.assertFalse(result);
    }
}
