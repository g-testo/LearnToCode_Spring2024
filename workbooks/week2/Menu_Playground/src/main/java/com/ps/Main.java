package com.ps;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plant plant1 = new Plant(1, "Morning Glory", 4);
        Plant plant2 = new Plant(2, "Marigold", 4);
        Plant plant3 = new Plant(3, "Heart Leaf", 2);
        Plant plant4 = new Plant(4, "Christmas Cactus", 1);

        Plant[] plantInventory = {plant1, plant2, plant3, plant4};


        int command;
        do {
            System.out.println("Please choose an option: ");
            System.out.println("\t1) Read about our company");
            System.out.println("\t2) Show all plants");
            System.out.println("\t3) Plant menu");
            System.out.println("\t4) Exit");

            Scanner scanner = new Scanner(System.in);
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Read about our company: Our company is awesome!");
                    break;
                case 2:
                    System.out.println("Show all Plants!");
                    for (Plant plant : plantInventory) {
                        System.out.println(plant);
                    }
                    break;
                case 3:
                    System.out.println("Plant menu!");

                    int plantCommand;
                    do {
                        System.out.println("Please choose an option: ");
                        System.out.println("\t1) Propagate plant");
                        // Ask which plant
                        System.out.println("\t2) Set plant ready to propagate");
                        // Ask which plant
                        System.out.println("\t3) Water plant");
                        // Ask which plant
                        System.out.println("\t4) Water All plants");

                        System.out.println("\t5) Back");

                        plantCommand = scanner.nextInt();

                        switch (plantCommand) {
                            case 1:
                                System.out.println("Selected Propagate plant");
                                break;
                            case 2:
                                System.out.println("Selected Set plant ready to propagate");
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Command not found");
                        }
                    } while (plantCommand != 5);


                    break;
                default:
                    System.out.println("Command not found");
            }
        } while (command != 4);
        // Read About Company
        // Show All Plants


    }
}