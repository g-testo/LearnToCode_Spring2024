package com.ps;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlantNursery {
    ArrayList<Plant> plants = new ArrayList<>();

    public void addPlant(Plant plant){
        plants.add(plant);
    }

    public ArrayList<Plant> getAllPlants(){
        return this.plants;
    }

    public void removePlant(Plant plant){
        this.plants.remove(plant);
    }

    public ArrayList<Plant> getAllPlantsByStatus(String status){
        ArrayList<Plant> plantsFilteredByStatus = new ArrayList<>();
        for(Plant plant: this.plants){
            if(plant.getStatus().equalsIgnoreCase(status)){
                plantsFilteredByStatus.add(plant);
            }
        }
        return plantsFilteredByStatus;
    }

}
