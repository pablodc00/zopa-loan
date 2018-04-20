package io.zopa.loanmanager.model;

public class MarketFile {
    
    private String borrower;
    private double rate;
    private int offer;    
    
    public MarketFile(String borrower, double rate, int offer) {
        this.borrower = borrower;
        this.rate = rate;
        this.offer = offer;
    }

    public String getBorrower() {
        return borrower;
    }
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public int getOffer() {
        return offer;
    }
    public void setOffer(int offer) {
        this.offer = offer;
    }

}
