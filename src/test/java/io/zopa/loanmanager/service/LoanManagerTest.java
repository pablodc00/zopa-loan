package io.zopa.loanmanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.zopa.loanmanager.model.LoanResult;
import io.zopa.loanmanager.model.MarketFile;

public class LoanManagerTest {
    
    
    private String filePath;
    private LoanManager loanManager = new LoanManager();
    private CsvParser csvParser = new CsvParser();
    
    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();
        filePath = classLoader.getResource("MarketDataforExercise-csv.csv").getFile();
    }
    
    @Test
    public void getLoanResultAndReturn() throws IOException {
        List<MarketFile> marketFileList = csvParser.processInputFile(filePath);
        LoanResult loanResult = loanManager.getLoanResult(marketFileList, 1000);
        assertNotNull(loanResult);
        assertEquals((Double)loanResult.getRate(), (Double)7.004);
        assertEquals(loanResult.getRequestAmount(), 1000);
    }
    
    @Test
    public void getLoanResultAndReturnNotOffers() throws IOException {
        List<MarketFile> marketFileList = csvParser.processInputFile(filePath);
        LoanResult loanResult = loanManager.getLoanResult(marketFileList, 1000000);
        assertNull(loanResult);        
    }
    
}
