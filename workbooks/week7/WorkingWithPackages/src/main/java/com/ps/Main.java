package com.ps;

import com.ps.inventory.Product;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1, "Test");
        System.out.println(product);
        ArrayList<String> arrayList = new ArrayList<>(
                Arrays.asList("one","two","three")
        );
        for(String str: arrayList){
            System.out.println(str);
        }
    }

}