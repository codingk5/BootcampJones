package org.example;

public class SalesContract extends Contract{
    private final double SALES_TAX = 0.05;
    private final int RECORDING_FEE = 100;
    private final int PROCESSING_FEE_OVER = 495;
    private final int PROCESSING_FEE_UNDER = 295;
    private boolean isFinanced;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, double totalPrice, double monthlyPayment, Vehicle vehicle, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment, vehicle);
        this.isFinanced = isFinanced;
    }

    public double getSALES_TAX() {
        return vehicle.getPrice() * SALES_TAX;
    }

    public int getRECORDING_FEE() {
        return RECORDING_FEE;
    }

    public int getProcessingFee() {
        return vehicle.getPrice() < 10000 ? PROCESSING_FEE_UNDER : PROCESSING_FEE_OVER;
    }


    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;


    }
    public double totalPrice() {
        return  vehicle.getPrice() + getSALES_TAX() + RECORDING_FEE + getProcessingFee();
    }

    @Override
    public void printReceicpt() {

    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) return 0.0;

        double loanAmount = totalPrice();
        double interestRate;
        int termMonths;

        if (vehicle.getPrice() >= 10000) {
            interestRate = 0.0425;
            termMonths = 48;
        } else {
            interestRate = 0.0525;
            termMonths = 24;
        }

        double monthlyRate = interestRate / 12;
        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, termMonths));
    }

    @Override
    public String printReceipt() {
        System.out.println("Sales Contract:");
        System.out.println("Date: " + getDateOfContract());
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Vehicle: " + vehicle);
        System.out.printf("Base Price: $%.2f\n", vehicle.getPrice());
        System.out.printf("Sales Tax (5%%): $%.2f\n", getSALES_TAX());
        System.out.printf("Recording Fee: $%d\n", RECORDING_FEE);
        System.out.printf("Processing Fee: $%d\n", getProcessingFee());
        System.out.printf("Total Price: $%.2f\n", totalPrice());

        if (isFinanced) {
            System.out.println("Financing: YES");
            System.out.printf("Monthly Payment: $%.2f\n", getMonthlyPayment());
        } else {
            System.out.println("Financing: NO");
        }

        return null;
    }
}
