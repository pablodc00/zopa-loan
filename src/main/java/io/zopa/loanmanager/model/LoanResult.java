package io.zopa.loanmanager.model;

public class LoanResult {
    
    public LoanResult(int requestAmount, double rate, double monthlyRepayment, double totalRepayment) {
        this.requestAmount = requestAmount;
        this.rate = rate;
        this.monthlyRepayment = monthlyRepayment;
        this.totalRepayment = totalRepayment;
    }
    
    private int requestAmount;
    private double rate;
    private double monthlyRepayment;
    private double totalRepayment;

    public int getRequestAmount() {
        return requestAmount;
    }
    public void setRequestAmount(int requestAmount) {
        this.requestAmount = requestAmount;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }
    public void setMonthlyRepayment(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }
    public double getTotalRepayment() {
        return totalRepayment;
    }
    public void setTotalRepayment(double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Requested amount: £" + this.requestAmount + "\n");
        sb.append("Rate: " + String.format( "%.1f", this.rate ) + "%\n");
        sb.append("Monthly repayment: £" + String.format( "%.2f", this.monthlyRepayment ) + "\n");
        sb.append("Total repayment: £" + String.format( "%.2f", this.totalRepayment ) + "\n");
        return sb.toString();
    }


}
