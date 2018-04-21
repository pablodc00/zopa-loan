package io.zopa.loanmanager.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.zopa.loanmanager.model.MarketFile;

public class CsvParserTest {

    private String filePath;
    
    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();
        filePath = classLoader.getResource("MarketDataforExercise-csv.csv").getFile();
    }
    

    @Test
    public void processInputFileTest() throws IOException {


        CsvParser cvsParser = new CsvParser();
        List<MarketFile> marketFileList = cvsParser.processInputFile(filePath);
        assertEquals(marketFileList.size(), 7);
        MarketFile marketFile = marketFileList.get(0);
        assertEquals(marketFile.getBorrower(), "Jane");
        marketFile = marketFileList.get(6);
        assertEquals(marketFile.getBorrower(), "Mary");
        
    }
}
