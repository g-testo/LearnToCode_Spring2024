package com.ps;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    // Wrapper
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
//        loadInventory();
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

    // loadInventory
}