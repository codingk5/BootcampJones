package org.example;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;


public class FileManager {
        public Dealership getDealership() {
            Dealership dealership = new Dealership("","","",null);
            FileInputStream fileInputStream = null;
            Scanner scanner = null;
            try {
                fileInputStream = new FileInputStream("src/main/resources/inventory2.csv");
                FileReader fileReader = new FileReader("src/main/resources/inventory2.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                scanner = new Scanner(fileInputStream);

                String input;
                boolean isFirstLine = true;

                ArrayList<Vehicle> vehicleList = new ArrayList<>();
                // D & B Used Cars|111 Old Benbrook Rd|817-555-5555
                //10112|1993|Ford|Explorer|SUV|Red|525123|995.00

                while ((input = bufferedReader.readLine()) != null) {
                    String[] row = input.split("\\|");

                    if (isFirstLine) {
                        // reading dealership info (1st line only)
                        dealership.setName(row[0]);
                        dealership.setAddress(row[1]);
                        dealership.setPhone(row[2]);
                        isFirstLine = false;
                        // change isFirstLine = false
                    } else {
                        Vehicle vehicle = new Vehicle(0,0,"","","","",0,0);
                        vehicle.setVin(Integer.parseInt(row[0]));
                        vehicle.setYear(Integer.parseInt(row[1]));
                        vehicle.setMake(row[2]);
                        vehicle.setModel(row[3]);
                        vehicle.setVehicleType(row[4]);
                        vehicle.setColor(row[5]);
                        vehicle.setOdometer(Integer.parseInt(row[6]));
                        vehicle.setPrice(Double.parseDouble(row[7]));
                        vehicleList.add(vehicle);
                        // reading vehicle info
                    }
                }


                dealership.inventory = vehicleList;

                bufferedReader.close();
                return dealership;
            } catch(IOException ex) {
                System.out.println("Failed to load file.");
                ex.printStackTrace();
                return dealership;
            }   }

    public static void saveDealership(Dealership dealership) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory2.csv");
                String headerRow = format("%s|%s|%s %n", dealership.getName(),dealership.getAddress(),dealership.getPhone());
                fileWriter.write(headerRow);
            for (Vehicle vehicle : dealership.getAllVehicle()){
                    String row = format("%d|%d|%s|%s|%s|%s|%d|%.2f", vehicle.getVin(), vehicle.getYear()
                            , vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

                    fileWriter.write(row);

            }
            fileWriter.close();
        }
         catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Could not save vehicles: ");
        }

    }
    }




