package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private FileManager fileManager = new FileManager();
    private Scanner scanner = new Scanner(System.in);

    public void display() throws IOException {
        init();

        String[] options = {
                "View Vehicles",
                "Filter by Price",
                "Filter by Year",
                "Filter by Color",
                "Filter by Odometer",
                "Filter by Type",
                "Add Vehicle",
                "Remove Vehicle",
                "Save Updated Dealership",
                "Sell Vehicle",
                "Lease Vehicle",
                "Exit Dealership"
        };

        while (true) {
            System.out.println("\nK&J Dealership Menu:");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ") " + options[i]);
            }
            System.out.print("What would you like to do? ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    processGetAllVehiclesRequest();
                    break;
                case 2:
                    processGetByPriceRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByOdometerRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processAddVehicleRequest();
                    break;
                case 8:
                    processRemoveVehicleRequest();
                    break;
                case 9:
                    FileManager.saveDealership(dealership);
                    System.out.println("Thanks for visiting K&J Dealership!");
                    return;
                case 10:
                    processSale();
                    return;
                case 11:
                    processLease(scanner);
                    return;
                default:
                    System.out.println("Not an option. Try again.");
                    break;
            }
        }
    }



    public void init() {
        fileManager = new FileManager();
        dealership = fileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles, String message) {
        System.out.println(message);
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicle();
        displayVehicles(vehicles, "All Vehicles");
    }

    private void processGetByPriceRequest() {
        try {
            System.out.print("Input Minimum Price: ");
            double minPrice = scanner.nextDouble();
            System.out.print("Input Maximum Price: ");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine();

            if (minPrice > maxPrice) {
                System.out.println("Minimum price then maximum price please.");
                return;
            }

            List<Vehicle> vehicleList = dealership.getVehicleByPrice(minPrice, maxPrice);

            displayVehicles(vehicleList, "Vehicles between $" + minPrice + " and $" + maxPrice);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number in relation to price.");
            scanner.nextLine();
        }
    }

    private void processGetByYearRequest() {
        try {
            System.out.print("Enter year ");
            int year = scanner.nextInt();
            scanner.nextLine();

            List<Vehicle> vehicles = dealership.getVehicleByYear(year);

            displayVehicles(vehicles, "Vehicles from year " + year);
        } catch (Exception e) {
            System.out.println("Wrong input, year please.");
            scanner.nextLine();
        }
    }

    private void processGetByColorRequest() {
        System.out.print("Enter color");
        String color = scanner.nextLine().trim();

        List<Vehicle> vehicleList = dealership.getVehicleByColor(color);

        displayVehicles(vehicleList, "Vehicles in color " + color);
    }

    private void processGetByOdometerRequest() {
        try {
            System.out.print("Enter max odometer miles: ");
            int maxMiles = scanner.nextInt();
            scanner.nextLine();

            List<Vehicle> vehicleList = dealership.getVehicleByOdometer(maxMiles);

            displayVehicles(vehicleList, "Vehicles with " + maxMiles + " miles or less");
        } catch (Exception e) {
            System.out.println("Input not valid. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type (e.g., SUV, Truck): ");
        String vehicleType = scanner.nextLine().trim();

        List<Vehicle> vehicles = dealership.getVehicleByVehicleType(vehicleType);

        displayVehicles(vehicles, "Vehicles of type " + vehicleType);
    }

    private void processGetByMakeModel() {
        // ask for make then model
        System.out.println("Type make");
        String make = scanner.nextLine();
        System.out.println("Type model");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByMakeModel(make, model);


    }

    private void processAddVehicleRequest() {
        try {
            System.out.print("Enter VIN: ");
            int vin = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Make: ");
            String make = scanner.nextLine();

            System.out.print("Enter Model: ");
            String model = scanner.nextLine();

            System.out.print("Enter Type: ");
            String type = scanner.nextLine();

            System.out.print("Enter Color: ");
            String color = scanner.nextLine();

            System.out.print("Enter Odometer: ");
            int odometer = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
            dealership.getAllVehicle().add(newVehicle);
            System.out.println("You added a vehicle!");

        } catch (Exception e) {
            System.out.println("Something went wrong, try again.");
            scanner.nextLine();
        }
    }

    public void processRemoveVehicleRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicle();

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to remove.");
            return;
        }

        System.out.println("Available Vehicles:");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }

        System.out.print("Enter the VIN of the vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle foundVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                foundVehicle = vehicle;
                break;
            }
        }

        if (foundVehicle != null) {
            dealership.removeVehicle(foundVehicle);
            System.out.println("Vehicle removed.");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }




    // find the vehicle w/ vin
        // then remove vehicle
    private void processByVinRequest() {
        System.out.print("Please enter VIN of vehicle: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle foundVehicle = null;
        for (Vehicle vehicle : dealership.getAllVehicle()) {
            if (vehicle.getVin() == vin) {
                foundVehicle = vehicle;
                break;
            }
        }

        if (foundVehicle == null) {
            System.out.println("Vehicle " + vin + " not found.");
        } else {
            dealership.removeVehicle(foundVehicle);
            System.out.println("Vehicle removed: " + foundVehicle);
        }
    }


    public void processSale() {
        List<Vehicle> vehicles = dealership.getAllVehicle();

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available for sale.");
            return;
        }

        // Show vehicles
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        // Ask for VIN
        System.out.print("Enter the VIN of the vehicle to sell: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Find vehicle
        Vehicle selectedVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle with VIN " + vin + " not found.");
            return;
        }

        // Get customer info
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Is this financed? (yes or no): ");
        String financeInput = scanner.nextLine();
        boolean isFinanced = financeInput.equalsIgnoreCase("yes");

        // Pricing
        double price = selectedVehicle.getPrice();
        double salesTax = price * 0.05;
        double recordingFee = 100.0;
        double processingFee = (price < 10000) ? 295.0 : 495.0;
        double totalPrice = price + salesTax + recordingFee + processingFee;

        // Financing
        double monthlyPayment = 0.0;
        if (isFinanced) {
            int months = (price >= 10000) ? 48 : 24;
            double rate = (price >= 10000) ? 0.0425 : 0.0525;
            double monthlyRate = rate / 12;
            monthlyPayment = (totalPrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
        }

        // Create and print contract
        String dateOfContract = java.time.LocalDate.now().toString();
        SalesContract contract = new SalesContract(dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment, selectedVehicle, isFinanced);

        System.out.println(contract.printReceipt());

        dealership.removeVehicle(selectedVehicle);
        System.out.println("Vehicle has been sold and removed from inventory.");
    }

    public void processLease(Scanner scanner) {
        List<Vehicle> vehicles = dealership.getAllVehicle();

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available for lease.");
            return;
        }

        System.out.println("Only vehicles from the last 3 years can be leased.");
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        System.out.print("Enter the VIN of the vehicle to lease: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Vehicle selectedVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        int currentYear = LocalDate.now().getYear();
        if (selectedVehicle.getYear() < currentYear - 3) {
            System.out.println("Sorry, that vehicle is too old to lease.");
            return;
        }

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        // Lease calculations
        double price = selectedVehicle.getPrice();
        double expectedEndingValue = price * 0.50; // 50% of original price
        double leaseFee = price * 0.07; // 7% of price
        double totalPrice = price + leaseFee;

        // Monthly payment calculation: 4% over 36 months
        double monthlyRate = 0.04 / 12;
        int months = 36;
        double monthlyPayment = (totalPrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));

        String dateOfContract = LocalDate.now().toString();

        // Create lease contract
        LeaseContract leaseContract = new LeaseContract(
                dateOfContract,
                customerName,
                customerEmail,
                totalPrice,
                monthlyPayment,
                selectedVehicle,
                expectedEndingValue,
                leaseFee
        );

        // Print lease receipt
        System.out.println(leaseContract.printReceipt());

        // Remove vehicle from inventory
        dealership.removeVehicle(selectedVehicle);
        System.out.println("Vehicle has been leased and removed from inventory.");
    }








}

