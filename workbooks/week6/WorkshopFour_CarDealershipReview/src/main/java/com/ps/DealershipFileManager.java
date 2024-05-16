package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public Dealership getDealership(){
        try{
            BufferedReader bufReader = new BufferedReader(new FileReader("DB_Dealership.csv"));

            String firstLine = bufReader.readLine();
            String[] splitFirstLine = firstLine.split("\\|");

            String name = splitFirstLine[0];
            String address = splitFirstLine[1];
            String phone = splitFirstLine[2];

            Dealership dealership = new Dealership(name, address, phone);

            String input;

            while((input = bufReader.readLine()) != null){

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
            return dealership;
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void saveDealership(Dealership dealership){

    }
}
