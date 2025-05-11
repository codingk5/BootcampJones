package org.example;

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
    public List<Vehicle> getVehicleByPrice(double min, double max){return null;}
    public List<Vehicle> getVehicleByMakeModel(String make, String model){return null;}
    public List<Vehicle> getVehicleByYear(int min, int max){return null;}
    public List<Vehicle> getVehicleByColor(String color){return null;}
    public List<Vehicle> getVehicleByOdometer(int min, int max){return null;}
    public List<Vehicle> getVehicleByVehicleType(String vehicleType){return null;}

    public void removeVehicle(Vehicle vehicle){
        if (inventory.contains(vehicle)){
            inventory.remove(vehicle);
            System.out.println("Vehicle " + vehicle + " removed.");
        }
        else {
            System.out.println("Vehicle not in inventory.");
        }

    }





}
