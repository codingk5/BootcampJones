package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Dealership {
    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle>inventory;

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void addVehicle(Vehicle vehicle){
       inventory.add(vehicle);
    }
    public  List<Vehicle> getAllVehicle(){
        return  inventory;
    }
    public List<Vehicle> getVehicleByPrice(double min, double max){return price;}
    public List<Vehicle> getVehicleByMakeModel(String make, String model){return null;}
    public List<Vehicle> getVehicleByYear(int year){return null;}
    public List<Vehicle> getVehicleByColor(String color){return null;}
    public List<Vehicle> getVehicleByOdometer(int odometer){return null;}
    public List<Vehicle> getVehicleByVehicleType(String vehicleType){return null;}
    public List<Vehicle> getVehicleByVin(int vin){return null;}

    public void removeVehicle(Vehicle vehicle){
        if (inventory.contains(vehicle)){
            inventory.remove(vehicle);
            System.out.println("Vehicle " + vehicle + " removed.");
        }
        else {
            System.out.println("Vehicle not in inventory.");
        }

    }





        public static void recordTransaction() {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter customer's full name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter customer's email: ");
            String customerEmail = scanner.nextLine();

            System.out.print("Enter vehicle make: ");
            String make = scanner.nextLine();

            System.out.print("Enter vehicle model: ");
            String model = scanner.nextLine();

            System.out.print("Enter vehicle year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter vehicle price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();


            String transactionType = "";
            while (true) {
                System.out.print("Is this a sale or lease? (Enter 'sale' or 'lease'): ");
                transactionType = scanner.nextLine().trim().toLowerCase();

                if (transactionType.equals("lease") && (2025 - year > 3)) {
                    System.out.println("You can't lease a vehicle over 3 years old.");
                } else if (transactionType.equals("sale") || transactionType.equals("lease")) {
                    break;
                } else {
                    System.out.println("Please enter 'sale' or 'lease'.");
                }
            }

            double totalPrice;
            if (transactionType.equals("sale")) {
                double salesTax = price * 0.05;
                totalPrice = price + salesTax;
                System.out.println("Sale Summary:");
                System.out.println("Price: $" + price);
                System.out.println("Sales Tax (5%): $" + salesTax);
                System.out.println("Total: $" + totalPrice);
            } else {
                double leaseMonthlyPayment = price / 36;
                System.out.println("Lease Summary:");
                System.out.println("Monthly Payment (36 months): $" + String.format("%.2f", leaseMonthlyPayment));
            }

            System.out.println("Transaction recorded for " + customerName + ".");
        }

        public static void main(String[] args) {
            recordTransaction();
        }
    }







