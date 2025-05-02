package org.example;

public class EmployeeData {

private int employeeId;
private String name;
private double hoursWorked;
private double payRate;
private double grossPay;

public EmployeeData(int employeeId, String name, double hoursWorked, double payRate, double
                     grossPay) {
    this.employeeId = employeeId;
    this.name = name;
    this.hoursWorked = hoursWorked;
    this.payRate = payRate;

}
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    public void getGrosspay(double grossPay) {
    return;
    }
    public void setGrossPay(double grossPay) {
    this.grossPay = payRate * hoursWorked;
    }

}
