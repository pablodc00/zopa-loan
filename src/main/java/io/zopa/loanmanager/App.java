package io.zopa.loanmanager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import io.zopa.loanmanager.model.LoanResult;
import io.zopa.loanmanager.model.MarketFile;
import io.zopa.loanmanager.service.CsvParser;
import io.zopa.loanmanager.service.LoanManager;

/**
 * Zopa loan manager
 * @author Pablo DCristofaro
 */
public class App 
{
    public static void main( String[] args )
    {
        if (args.length < 2) {
            System.err.println("Expected arguments not found.");
            System.err.println("Usage: mvn exec:java -Dexec.mainClass=\"io.zopa.loanmanager.App\" -Dexec.args=\"<csv-data-file> <desired-amount>\" ");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if (!file.exists()) {
            System.err.println(args[0] + " does not exists.");
            System.exit(1);
        }

        if (!file.isFile()) {
            System.err.println(args[0] + " is not a file.");
            System.exit(1);
        }

        int loanAmount = 0;
        try {
            loanAmount = Integer.parseInt(args[1]);
        } catch(NumberFormatException e) { 
            System.err.println(args[1] + " is not a valid loan amount.");
            System.exit(1);
        }
     
        if (loanAmount < 1000 || loanAmount > 15000) {
            System.err.println("Loan amount must be between £1000 and £15000 inclusive.");
            System.exit(1);
        }
        
        if (loanAmount % 100 != 0) {
            System.err.println("Loan amount must be £100 increment.");
            System.exit(1);            
        }
        
        CsvParser csvParser = new CsvParser();
        List<MarketFile> marketFileList = null;
        try {
            marketFileList = csvParser.processInputFile(args[0]);
        } catch (IOException e) {
            System.err.println("Unexpected error:");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        LoanManager loanManager = new LoanManager();
        LoanResult loanResult = loanManager.getLoanResult(marketFileList, loanAmount);
        if (null == loanResult) {
            System.out.println("It is not possible to provide a quote at this time.");
            System.exit(1);
        }
       
        System.out.println(loanResult.toString());
        
    }
}
