package io.zopa.loanmanager.service;

import java.util.List;

import io.zopa.loanmanager.model.LoanResult;
import io.zopa.loanmanager.model.MarketFile;
import io.zopa.loanmanager.util.LoanConstants;

public class LoanManager {
    
    public LoanResult getLoanResult(List<MarketFile> marketFileList, int loanAmount) {
        
        double totalRate = 0.0;
        int remainingAmount = loanAmount;
        
        // accumulate offers to reach desired loan amount 
        for (MarketFile marketFile : marketFileList) {
            int borrowedAmount = Math.min(remainingAmount, marketFile.getOffer());
            totalRate += borrowedAmount * marketFile.getRate();
            remainingAmount -= borrowedAmount;
            if (remainingAmount == 0) {
                break;
            }
        }
        
        // if the market does not have sufficient offers from lenders to satisfy the loan 
        if (remainingAmount > 0) {
            return null;
        }
        
        double annualRate = totalRate / loanAmount;
        double monthlyRate = annualRate / 12;
        
        
        // Reference: http://www.financeformulas.net/Loan_Payment_Formula.html
        double nom = monthlyRate * loanAmount;
        double den = 1 - Math.pow(1 + monthlyRate, - LoanConstants.LOAN_TERMS);
        
        double monthlyRepayment = nom / den;

        return new LoanResult(
                loanAmount, annualRate * 100, monthlyRepayment, monthlyRepayment * LoanConstants.LOAN_TERMS);
    }


}
