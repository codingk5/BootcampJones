package org.example;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.example.Menu.DealershipUI.inventory;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    // constructor

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
//        return vin + " | " + year + " | " + make + " " + model + " | " + vehicleType + " | " + color + " | " + odometer + " | " + price;
        return String.format(
                "%d|%d|%s|%s|%s|%s|%d|$%.2f",
                vin, year, make, model, vehicleType, color, odometer, price
        );

    }
    public static void saveInventoryToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("vehicles.txt"))) {
            for (Vehicle vehicle : inventory) {
                writer.println(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not save vehicles: " + e.getMessage());
        }
    }




}
