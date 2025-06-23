package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserInterface userInterface = new UserInterface();
        userInterface.display();

        String userName = args[0];
        String password = args[1];


        public static void main(String[] args) {
            VehicleDAO dao = new VehicleDAO();

            // Add a vehicle
            dao.addVehicle("1HGCM82633A004352", "Honda", "Accord", 2020, 18000.00, false);

            // Remove a vehicle
            dao.removeVehicle("1HGCM82633A004352");
        }




    }
}