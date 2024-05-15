package com.ps;

public class Jewelry extends Asset{

    public Jewelry(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

    @Override
    public double getValue() {
        return 0;
    }

}
