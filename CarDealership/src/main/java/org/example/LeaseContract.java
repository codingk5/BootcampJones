package org.example;

public class LeaseContract extends Contract {
    private  double expectedEndingValue;
    private double leaseFee;

    private static final double ENDING_VALUE_RATE = 0.50;
    private static final double LEASE_FEE_RATE = 0.07;
    private static final double INTEREST_RATE = 0.04; // 4%
    private static final int TERM_MONTHS = 36;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, double totalPrice, double monthlyPayment, Vehicle vehicle, double expectedEndingValue, double leaseFee) {
        super(dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment, vehicle);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }
    public double getENDING_VALUE_RATE(){
        return ENDING_VALUE_RATE;
    }
    public double getINTEREST_RATE(){
        return INTEREST_RATE;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getlease() {
        return LEASE_FEE_RATE;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public String printReceipt() {

        return null;
    }

    @Override
    public double totalPrice() {
        return  getMonthlyPayment() * TERM_MONTHS;
    }

    @Override
    public void printReceicpt(){
        System.out.println("Lease Contract");
        System.out.println("Date: " + getDateOfContract());
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Vehicle: " + vehicle);
        System.out.printf("Expected Ending Value: $%.2f\n", expectedEndingValue);
        System.out.printf("Lease Fee: $%.2f\n", leaseFee);
        System.out.printf("Monthly Payment: $%.2f\n", getMonthlyPayment());
        System.out.printf("Total Lease Cost: $%.2f\n", totalPrice());
    }
}
