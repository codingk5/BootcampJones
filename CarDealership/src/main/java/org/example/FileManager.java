package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileManager {
        public Dealership getDealership() {
            Dealership dealership = new Dealership("","","",null);
            try {
                FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

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
            }
        }


}
