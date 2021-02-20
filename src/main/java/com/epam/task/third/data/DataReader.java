package com.epam.task.third.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private final static Logger LOGGER = LogManager.getLogger(DataReader.class);

    private final String filename;

    public DataReader(String filename) {
        this.filename = filename;
    }

    public List<String> readData() throws DataException {
        LOGGER.info("Method readData from a file " + this.filename + " started.");
        List<String> processedLines = new ArrayList();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.filename));
            String line;
            while ((line = reader.readLine()) != null) {
                processedLines.add(line);
            }
            LOGGER.info("Method readData from a file" + this.filename + " finished. The data has been read successfully.");
            return processedLines;
        } catch (IOException e) {
            throw new DataException("The file hasn't been found!", e, this.filename);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.warn("I/O exception", e);
                }
            }
        }
    }
}
