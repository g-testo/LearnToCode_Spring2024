package com.ps;

import java.util.ArrayList;

public class Main {
    static PlantNursery nursery = new PlantNursery();

    public static void main(String[] args) {
        // Initialize with values
        Plant plant1 = new Plant(1, "Succulent", "Good", 9.99f);
        Plant plant2 = new Plant(2, "Rose", "Poor", 19.99f);
        Plant plant3 = new Plant(3, "Rose", "Good", 29.99f);

        nursery.addPlant(plant1);
        nursery.addPlant(plant2);
        nursery.addPlant(plant3);

        ArrayList<Plant> allPlants = nursery.getAllPlants();

        allPlants.remove(plant3);

        for(Plant plant: allPlants){
            System.out.printf("Plant: id: %d type: %-10s status: %s  \n", plant.getId(), plant.getType(), plant.getStatus());
        }

//        ArrayList<Plant> statusFilteredPlants = nursery.getAllPlantsByStatus("poor");
//        System.out.println(statusFilteredPlants);

    }
}