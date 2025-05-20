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
                "Remove by Vin",
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
                    processGetByMakeModel();
                    return;
                case 11:
                    processByVinRequest();
                    return;
                case 12:
                    processSale(scanner);
                    return;
                case 13:
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

            List<Vehicle> vehicleList = new ArrayList<>();
            dealership.getVehicleByPrice(minPrice, maxPrice);

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

            List<Vehicle> vehicleList = new ArrayList<>();
            dealership.getVehicleByYear(year);

            displayVehicles(vehicleList, "Vehicles from year " + year);
        } catch (Exception e) {
            System.out.println("Wrong input, year please.");
            scanner.nextLine();
        }
    }

    private void processGetByColorRequest() {
        System.out.print("Enter color");
        String color = scanner.nextLine();

        List<Vehicle> vehicleList = new ArrayList<>();
        dealership.getVehicleByColor(color);


        displayVehicles(vehicleList, "Vehicles in color " + color);
    }

    private void processGetByOdometerRequest() {
        try {
            System.out.print("Enter max odometer miles: ");
            int maxMiles = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<Vehicle> vehicleList = new ArrayList<>();
            dealership.getVehicleByOdometer(maxMiles);

            displayVehicles(vehicleList, "Vehicles with " + maxMiles + " miles or less");
        } catch (Exception e) {
            System.out.println("Input not valid. Please enter a valid number.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type (e.g., SUV, Truck): ");
        String type = scanner.nextLine();

        List<Vehicle> vehicleList = new ArrayList<>();
         dealership.getVehicleByVehicleType(type);

        displayVehicles(vehicleList, "Vehicles of type " + type);
    }

    private void processGetByMakeModel() {
        // ask for make then model
        System.out.println("Type make");
        String make = scanner.nextLine();
        System.out.println("Type model");
        String model = scanner.nextLine();
        List<Vehicle> vehicle = new ArrayList<>();
         dealership.getVehicleByMakeModel(make, model);


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
        for (Vehicle v : vehicles) {
            if (v.getVin() == vin) {
                foundVehicle = v;
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
        for (Vehicle v : dealership.getAllVehicle()) {
            if (v.getVin() == vin) {
                foundVehicle = v;
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


    public void processSale(Scanner scanner) {
        List<Vehicle> vehicles = dealership.getAllVehicle();


        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available for sale.");
            return;
        }


        System.out.println("Available Vehicles:");
        System.out.println(vehicles);


        System.out.print("Enter the vin of the vehicle ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        processByVinRequest();





        Vehicle selectedVehicle = vehicles.get(vin);
        String dateOfContract = "";
        int totalPrice = 0;
        double monthlyPayment = 0.00;
        List<Vehicle> vehicle = vehicles;



        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Is this financed? (yes or no): ");
        String financeInput = scanner.nextLine();
        boolean isFinanced = financeInput.equalsIgnoreCase("yes");


        Contract contract = new Contract(dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment, (Vehicle) vehicle) {
            @Override
            public String printReceipt() {

                return null;
            }

            @Override
            public double totalPrice() {
                return 0;
            }

            @Override
            public void printReceicpt() {

            }
        };



        contract.printReceipt();


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
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }

        System.out.print("Enter the VIN of the vehicle to lease: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle selectedVehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getVin() == vin) {
                selectedVehicle = v;
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

        String dateOfContract = "";
        double totalPrice = 0.0;
        double monthlyPayment = 0;
        Vehicle vehicle = selectedVehicle ;


        Contract contract = new Contract(dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment, vehicle) {

            @Override
            public String printReceipt() {
                return "";
            }

            @Override
            public double totalPrice() {
                return 0;
            }

            @Override
            public void printReceicpt() {

            }
        };
        double expectedEndingValue = 0.00;
        final double LEASE_FEE = 0.07;

        LeaseContract leaseContract = new LeaseContract(dateOfContract,customerName,customerEmail, totalPrice, monthlyPayment,vehicle, expectedEndingValue, LEASE_FEE);
        System.out.println(contract.printReceipt());

        dealership.removeVehicle(selectedVehicle);
        System.out.println("Vehicle has been leased and removed from inventory.");
    }





}

