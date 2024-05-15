package com.ps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        House jeremysHouse = new House(
                "Large and comfy",
                "05/14/2024",
                200_000,
                "123 Fourth Ave",
                2,
                4_000,
                30_000
        );

        House selamsHouse = new House(
                "Large and comfy aka mickeyMouseClubHouse",
                "05/14/2017",
                1_000_000,
                "1400 Washington Ave",
                1,
                4_001,
                29_999
        );

        Vehicle car = new Vehicle(
                "Sedan",
                "2022-08-15",
                25000.00,
                "Toyota Camry",
                2022,
                15000
        );

        Vehicle motorcycle = new Vehicle(
                "Sport Motorcycle",
                "2023-04-01",
                15000.00,
                "Yamaha YZF-R3",
                2023,
                100_001
        );

        assets.add(jeremysHouse);
        assets.add(selamsHouse);
        assets.add(car);
        assets.add(motorcycle);

        for(Asset asset: assets){
            System.out.printf("Description: %s, Asset Value: $%.2f\n", asset.getDescription(), asset.getValue());

            if(asset instanceof House) {
                House house = (House)asset;
                System.out.println(house.getAddress());
            } else if(asset instanceof Vehicle){
                Vehicle vehicle = (Vehicle)asset;
                System.out.println(vehicle.getMakeModel());
            }

        }

    }
}