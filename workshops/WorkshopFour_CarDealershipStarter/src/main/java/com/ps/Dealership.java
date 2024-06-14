package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getPrice() > min && vehicle.getPrice() < max){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehicleByYear(int min, int max){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getYear() > min && vehicle.getYear() < max){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getOdometer() > min && vehicle.getOdometer() < max){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByType(String type){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle: this.inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(type)){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);
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

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
