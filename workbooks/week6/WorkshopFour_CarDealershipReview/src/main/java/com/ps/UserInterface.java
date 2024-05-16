package com.ps;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private static Scanner scanner = new Scanner(System.in);

    public void display(){
        init();

        int mainMenuCommand;

        do{
            // Needs refactoring
            System.out.println("1- Find vehicles within a price range");
            System.out.println("2- Find vehicles by make / model");
            System.out.println("3- Find vehicles by year range");
            System.out.println("4- Find vehicles by color");
            System.out.println("5- Find vehicles by mileage range");
            System.out.println("6- Find vehicles by type (sedan, truck, SUV, van)");
            System.out.println("7- List ALL vehicles");
            System.out.println("8- Add a vehicle");
            System.out.println("9- Remove a vehicle");
            System.out.println("99- Quit");

            System.out.print("Please choose an option: ");

            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    break;
            }
        } while(mainMenuCommand != 99);
    }

    private void init(){
        this.dealership = DealershipFileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles){

        for(Vehicle vehicle: vehicles){
//            "----  All Vehicles ----
            System.out.printf("VIN: %d, Year: %d, Make: %s, Model: %s, Type: %s, Color: %s, Odometer: %d, Price: %.2f\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );
        }
    }

    public void processGetByPriceRequest(){
        System.out.print("Minimum price: ");
        int min = scanner.nextInt();
        System.out.print("Maximum price: ");
        int max = scanner.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(filteredVehicles);
    }
    public void processGetByMakeModelRequest(){
        scanner.nextLine(); // Consume Line

        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(filteredVehicles);
    }
    public void processGetByYearRequest(){
        System.out.print("Minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Maximum year: ");
        int max = scanner.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehicleByYear(min, max);
        displayVehicles(filteredVehicles);
    }
    public void processGetByColorRequest(){
        scanner.nextLine(); // Consume Line

        System.out.print("Color: ");
        String color = scanner.nextLine();

        List<Vehicle> filteredVehicles = dealership.getVehicleByColor(color);
        displayVehicles(filteredVehicles);
    }
    public void processGetByMileageRequest(){
        System.out.print("Minimum Mileage: ");
        int min = scanner.nextInt();
        System.out.print("Maximum Mileage: ");
        int max = scanner.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(filteredVehicles);
    }
    public void processGetByVehicleTypeRequest(){
        scanner.nextLine(); // Consume Line

        System.out.print("Vehicle type: ");
        String type = scanner.nextLine();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByType(type);
        displayVehicles(filteredVehicles);
    }
    public void processGetAllVehiclesRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        System.out.println("------ All Vehicles ------");
        displayVehicles(allVehicles);
    }
    public void processAddVehicleRequest(){
        System.out.print("VIN: ");
        int vin = scanner.nextInt();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        // Fix: Consume extra carriage
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        this.dealership.addVehicle(vehicle);

        DealershipFileManager.saveDealership(this.dealership);
    }
    public void processRemoveVehicleRequest(){
        List<Vehicle> allVehicles = this.dealership.getAllVehicles();
        displayVehicles(allVehicles);
        System.out.print("Which would you like to remove? VIN: ");
        int vin = scanner.nextInt();

        for(Vehicle vehicle: allVehicles){
            if(vehicle.getVin() == vin){
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle found and removed");
                DealershipFileManager.saveDealership(this.dealership);
                return;
            }
        }

        System.out.println("Vehicle not found");
    }
}
