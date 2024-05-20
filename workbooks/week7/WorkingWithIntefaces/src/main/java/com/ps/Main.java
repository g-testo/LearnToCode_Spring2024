package com.ps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        Gold block = new Gold("Block", 1_000_000);
        Jewelry ring = new Jewelry("Ring", 10_000);

        ArrayList<FixedAsset> assets = new ArrayList<>();
        assets.add(block);
        assets.add(ring);

        ArrayList<Valuable> valuables = new ArrayList<>();
        valuables.add(bankAccount);
        valuables.add(block);
        valuables.add(ring);

        int totalValue = 0;

        for(Valuable valuable: valuables){
            totalValue += valuable.getValue();
        }

        System.out.println(totalValue);
    }
}