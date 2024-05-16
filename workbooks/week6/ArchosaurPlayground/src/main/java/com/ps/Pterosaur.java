package com.ps;

public abstract class Pterosaur extends Archosaur{
    private float wingSpan;

    public Pterosaur(String species, int numOfLegs, float wingSpan) {
        super(species, numOfLegs);
        this.wingSpan = wingSpan;
    }

    public float getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(float wingSpan) {
        this.wingSpan = wingSpan;
    }
}
