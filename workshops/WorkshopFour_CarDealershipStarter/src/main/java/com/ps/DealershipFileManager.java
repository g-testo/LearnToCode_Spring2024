package com.ps;

import java.io.*;

public class DealershipFileManager {

    public static Dealership getDealership() {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("DB_Dealership.csv"));

            String firstLine = bufReader.readLine();
            String[] splitFirstLine = firstLine.split("\\|");

            String name = splitFirstLine[0];
            String address = splitFirstLine[1];
            String phone = splitFirstLine[2];

            Dealership dealership = new Dealership(name, address, phone);

            String input;

            while ((input = bufReader.readLine()) != null) {

                String[] splitInput = input.split("\\|");
                int vin = Integer.parseInt(splitInput[0]);
                int year = Integer.parseInt(splitInput[1]);
                String make = splitInput[2];
                String model = splitInput[3];
                String type = splitInput[4];
                String color = splitInput[5];
                int odometer = Integer.parseInt(splitInput[6]);
                float price = Float.parseFloat(splitInput[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);

                dealership.addVehicle(vehicle);
            }

            bufReader.close();

            return dealership;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveDealership(Dealership dealership) {
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("DB_Dealership.csv"));

            bufWriter.write(String.format("%s|%s|%s\n",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone()
            ));

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bufWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()
                ));
            }

            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
