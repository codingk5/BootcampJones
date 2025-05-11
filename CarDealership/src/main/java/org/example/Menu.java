package org.example;

import javax.swing.*;
import java.util.ArrayList;

public interface Menu {
    public class DealershipUI {
        static ArrayList<Vehicle> inventory = new ArrayList<>();



        public static void main(String[] args) {
            JOptionPane.showMessageDialog(null, "You are now entering K&J Dealership!");
            String[] options = {
                    "View Vehicles",
                    "Filter by Price",
                    "Filter by Year",
                    "Filter by Color",
                    "Filter by Odometer",
                    "Filter by Type",
                    "Add Vehicle",
                    "Remove Vehicle",
                    "Exit Dealership"
            };

            while (true) {
                String userInput = (String) JOptionPane.showInputDialog(null,
                        "Choose an action.",
                        "Dealership Menu",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (userInput == null || userInput.equals("Exit Dealership")) {
                    JOptionPane.showMessageDialog(null, "Thank You, Come Again");
                    break;
                }




         switch (userInput) {


             case "View Vehicles":
                 viewAllVehicles();
                 break;
             case "Filter by Price":
                 filterByPrice();
                 break;
             case "Filter by Year":
                 filterByYear();
                 break;
             case "Filter by Color":
                 filterByColor();
                 break;
             case "Filter by Odometer":
                 filterByOdometer();
                 break;
             case "Filter by Type":
                 filterByType();
                 break;
             case "Add Vehicle":
                 addVehicle();
                 break;
             case "Remove Vehicle":
                 removeVehicle();
                 break;
         }
        }
    }


public static void viewAllVehicles() {
    if (inventory.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No vehicles available.");
        return;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < inventory.size(); i++) {
        sb.append((i + 1) + ". " + inventory.get(i) + "\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString());
}

public static void filterByPrice() {
    try {
        double max = Double.parseDouble(JOptionPane.showInputDialog("Enter max price:"));
        StringBuilder sb = new StringBuilder("Vehicles under $" + max + ":\n");
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() <= max) {
                sb.append(vehicle).append("\n");
                found = true;
            }
        }
        if (!found) sb.append("No vehicles found.");
        JOptionPane.showMessageDialog(null, sb.toString());
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Invalid price.");
    }
}

public static void filterByYear() {
    try {
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter year:"));
        StringBuilder sb = new StringBuilder("Vehicles from " + year + ":\n");
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() == year) {
                sb.append(vehicle).append("\n");
                found = true;
            }
        }
        if (!found) sb.append("No vehicles found.");
        JOptionPane.showMessageDialog(null, sb.toString());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid year.");
    }
}

public static void filterByColor() {
    String color = JOptionPane.showInputDialog("Enter color:");
    StringBuilder sb = new StringBuilder("Vehicles in color " + color + ":\n");
    boolean found = false;
    for (Vehicle vehicle : inventory) {
        if (vehicle.getColor().equalsIgnoreCase(color)) {
            sb.append(vehicle).append("\n");
            found = true;
        }
    }
    if (!found) sb.append("No vehicles found.");
    JOptionPane.showMessageDialog(null, sb.toString());
}

public static void filterByOdometer() {
    try {
        int max = Integer.parseInt(JOptionPane.showInputDialog("Enter max odometer reading:"));
        StringBuilder sb = new StringBuilder("Vehicles with ≤ " + max + " miles:\n");
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() <= max) {
                sb.append(vehicle).append("\n");
                found = true;
            }
        }
        if (!found) sb.append("No vehicles found.");
        JOptionPane.showMessageDialog(null, sb.toString());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid number.");
    }
}

public static void filterByType() {
    String type = JOptionPane.showInputDialog("Enter type (e.g., SUV, Sedan):");
    StringBuilder sb = new StringBuilder("Vehicles of type " + type + ":\n");
    boolean found = false;
    for (Vehicle vehicle : inventory) {
        if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
            sb.append(vehicle).append("\n");
            found = true;
        }
    }
    if (!found) sb.append("No vehicles found.");
    JOptionPane.showMessageDialog(null, sb.toString());
}

public static void addVehicle() {
    try {
        int vin = Integer.parseInt(JOptionPane.showInputDialog("Input Vin")) ;
        String make = JOptionPane.showInputDialog("Input make:");
        String model = JOptionPane.showInputDialog("Input model:");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Input year:"));
        String color = JOptionPane.showInputDialog("Input color:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Input price:"));
        int odometer = Integer.parseInt(JOptionPane.showInputDialog("Input odometer:"));
        String vehicleType = JOptionPane.showInputDialog("Enter type (ex., SUV, Sedan):");

        Vehicle vehicle = new Vehicle(vin, year, make,model, vehicleType,color,odometer, price);
        inventory.add(vehicle);
        JOptionPane.showMessageDialog(null, "Vehicle added.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
    }
}

public static void removeVehicle() {
    if (inventory.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No vehicles to remove.");
        return;
    }


}
}
}




