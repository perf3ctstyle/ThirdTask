package com.epam.task.third.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataValidator {

    private final static Logger LOGGER = LogManager.getLogger(DataValidator.class);

    private final static int ZERO = 48;
    private final static int NINE = 57;
    private final static int DOT = 46;
    private final static int SPACE = 32;

    private final static int NUMBER_OF_COORDINATES_FOR_QUADRANGLE = 8;

    private final static String WHITESPACE_CHARACTER = "\s";

    public boolean validate(String data) {
        LOGGER.info("Method validate the following data: " + data + " started.");
        String[] coordinates = data.split(WHITESPACE_CHARACTER);
        int numberOfProcessedCoordinates = coordinates.length;
        if (numberOfProcessedCoordinates != NUMBER_OF_COORDINATES_FOR_QUADRANGLE) {
            LOGGER.info("Method validate the following data: " + data + " finished. " +
                    "The data isn't valid: The number of coordinates doesn't match the required number for creating a quadrangle.");
            return false;
        }
        int length = data.length();
        int i=0;
        while (i<length) {
            char currentChar = data.charAt(i);
            if ((currentChar < ZERO || currentChar > NINE) && currentChar != DOT && currentChar != SPACE) {
                LOGGER.info("Method validate the following data: " + data + " finished. " +
                        "The data isn't valid: Inappropriate symbol encountered.");
                return false;
            }
            i++;
        }
        LOGGER.info("Method validate the following data: " + data + " finished. The data is valid.");
        return true;
    }
}
