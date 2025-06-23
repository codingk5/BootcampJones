package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private final String connectionString;
    private final String userName;
    private final String password;

    public VehicleDao(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }
    public void addVehicle(String vin, String make, String model, int year, double price, boolean sold) {
        String sql = "INSERT INTO vehicles (vin, make, model, year, price, sold) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName,password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vin);
            stmt.setString(2, make);
            stmt.setString(3, model);
            stmt.setInt(4, year);
            stmt.setDouble(5, price);
            stmt.setBoolean(6, sold);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Vehicle added successfully.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(" Vehicle with this VIN already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove a vehicle from the database by VIN
    public void removeVehicle(String vin) {
        String sql = "DELETE FROM vehicles WHERE vin = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vin);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Vehicle removed successfully.");
            } else {
                System.out.println("Vehicle not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

