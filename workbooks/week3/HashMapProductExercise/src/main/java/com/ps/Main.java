package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    // Wrapper
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        loadInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What item # are you interested in?");
        int id = scanner.nextInt();

        Product matchedProduct = inventory.get(id);
        if(matchedProduct == null){
            System.out.println("Product not found");
        } else {
            System.out.printf("We carry %s and the price is $%.2f", matchedProduct.getName(), matchedProduct.getPrice());
        }
    }

    public static void loadInventory(){
        // Static
//        Product product1 = new Product(1,"Fluffy's mousse", 8.99f);
//        Product product2 = new Product(2,"Frizzy's hair brush", 4.99f);
//        Product product3 = new Product(3,"Gloppy's hair gel", 8.99f);
//
//        inventory.put(111, product1);
//        inventory.put(222, product2);
//        inventory.put(333, product3);
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("products.txt"));
            String input;
            while((input = bufferedReader.readLine()) != null){
                // input is: 111|Fluffy's mousse|8.99
                String[] splitInput = input.split("\\|"); // [ "111", "Fluffy's mousse", "8.99"]

                int id = Integer.parseInt(splitInput[0]);
                String name = splitInput[1];
                float price = Float.parseFloat(splitInput[2]);

                Product tempProduct = new Product(id, name, price);

                inventory.put(id, tempProduct);
            }
        } catch (IOException e){
            System.out.println("There was an error reading from the file");
            e.printStackTrace();
        }

    }
}