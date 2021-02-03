package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Quadrangle;
import com.epam.task.third.parsing.DataParser;
import com.epam.task.third.parsing.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class QuadrangleCreator {

    private final static Logger LOGGER = LogManager.getLogger(QuadrangleCreator.class);

    private final DataReader dataReader;
    private final DataParser dataParser;
    private final DataValidator dataValidator;

    public QuadrangleCreator(final DataReader dataReader, final DataParser dataParser, final DataValidator dataValidator) {
        this.dataReader = dataReader;
        this.dataParser = dataParser;
        this.dataValidator = dataValidator;
    }

    public List<Quadrangle> process() throws DataException {
        LOGGER.info("Method process started.");
        List<String> processedLines = dataReader.readData();
        int numOfProcessedLines = processedLines.size();
        for (int i=0; i<numOfProcessedLines; i++) {
            String lineToValidate = processedLines.get(i);
            if (!dataValidator.validate(lineToValidate)) {
                processedLines.remove(i);
                numOfProcessedLines--;
            }
        }
        List<Quadrangle> receivedQuadrangles = new ArrayList();
        for (int i=0; i<numOfProcessedLines; i++) {
            String lineToInitializeQuadrangle = processedLines.get(i);
            Quadrangle newQuadrangle = dataParser.createQuadrangle(lineToInitializeQuadrangle);
            receivedQuadrangles.add(newQuadrangle);
        }
        LOGGER.info("Method process finished. List of quadrangles has been created successfully.");
        return receivedQuadrangles;
    }
}
