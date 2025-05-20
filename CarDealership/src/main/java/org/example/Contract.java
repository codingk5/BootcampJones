package org.example;

public abstract class Contract {
    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    public Vehicle vehicle;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String dateOfContract, String customerName, String customerEmail, double totalPrice, double monthlyPayment, Vehicle vehicle) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public double getMonthlyPayment() {
        return monthlyPayment;
    }


    public abstract String printReceipt();


    public abstract double totalPrice();


    public abstract void printReceicpt();
}

