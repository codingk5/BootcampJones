package org.example;

import java.io.*;
import java.util.List;

public class ContractFileManager {
    public List<Contract> getContractsFromFile(String filePath) throws IOException {
        ContractFileManager fileManager = new ContractFileManager();
            List<Contract> contracts = fileManager.getContractsFromFile ("src/main/resources/contract.csv");

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] row = line.split("\\|");

                    if (row.length < 6) continue; // skip invalid rows

                    String type = row[0]; // SALE or LEASE
                    String dateOfContract = row[1];
                    String customerName = row[2];
                    String customerEmail = row[3];
                    int vin = Integer.parseInt(row[4]);
                    int year = Integer.parseInt(row[5]);

                    String make = row[6];
                    String model = row[7];
                    String vehicleType = row[8];
                    String color = row[9];
                    int odometer = Integer.parseInt(row[10]);
                    double price = Double.parseDouble(row[11]);
                    double monthlyPayment = Double.parseDouble(row[12]);



                    double expectedEndingValue = 0.00;
                    double totalPrice = 0.00;
                    double leaseFee = 0.07;


                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    Contract contract = new Contract(dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment, vehicle) {
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

                    if (type.equalsIgnoreCase("SALE")) {
                        boolean isFinanced = row[14].equalsIgnoreCase("YES");
                        Contract sale = new SalesContract(dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment,vehicle, isFinanced);
                        contracts.add(sale);
                    } else if (type.equalsIgnoreCase("LEASE")) {
                        Contract lease = new LeaseContract(dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment, vehicle, expectedEndingValue, leaseFee);
                        contracts.add(lease);
                    }
                }
            }

            return contracts;
        }
    public void saveContract(Contract contract) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/contract.csv", true))) {

            StringBuilder sb = new StringBuilder();

            // Common fields
            sb.append(contract instanceof SalesContract ? "SALE" : "LEASE").append("|");
            sb.append(contract.getDateOfContract()).append("|");
            sb.append(contract.getCustomerName()).append("|");
            sb.append(contract.getCustomerEmail()).append("|");

            Vehicle vehicle = contract.getVehicle();
            sb.append(vehicle.getVin()).append("|")
                    .append(vehicle.getYear()).append("|")
                    .append(vehicle.getMake()).append("|")
                    .append(vehicle.getModel()).append("|")
                    .append(vehicle.getVehicleType()).append("|")
                    .append(vehicle.getColor()).append("|")
                    .append(vehicle.getOdometer()).append("|")
                    .append(vehicle.getPrice()).append("|");

            // SalesContract
            if (contract instanceof SalesContract) {
                SalesContract sale = (SalesContract) contract;

                StringBuilder append = sb.append(String.format("%.2f|", sale.getSALES_TAX()))
                        .append(String.format("%.d|", sale.getRECORDING_FEE()));
                                sb.append(String.format("%.d|", sale.getProcessingFee()))
                                .append(String.format("%.2f|", sale.totalPrice()))
                                .append(sale.isFinanced() ? "YES" : "NO").append("|")
                                .append(String.format("%.2f", sale.getMonthlyPayment()));
            }

             else if (contract instanceof LeaseContract) {
                    LeaseContract lease = (LeaseContract) contract;

                    sb.append(String.format("%.2f|", lease.getExpectedEndingValue()))
                            .append(String.format("%.2f|", lease.getlease()))
                            .append(String.format("%.2f|", lease.totalPrice()))
                           .append(String.format("%.2f", lease.getMonthlyPayment()));
            }

            // Write the line
            writer.println(sb.toString());

            System.out.println("Contract saved to file.");

        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
    }
    }
}


