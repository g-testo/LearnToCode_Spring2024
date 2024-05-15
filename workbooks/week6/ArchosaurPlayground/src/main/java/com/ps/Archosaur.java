package com.ps;

public abstract class Archosaur {
    private String species;
    private int numOfLegs;
    private int energy;

    public Archosaur(String species, int numOfLegs) {
        this.species = species;
        this.numOfLegs = numOfLegs;
        this.energy = 100;
    }

    public abstract void eat();
    public abstract void sleep();
    public abstract void move();

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public String toString() {
        return "Archosaur{" +
                "species='" + species + '\'' +
                ", numOfLegs=" + numOfLegs +
                ", energy=" + energy +
                '}';
    }
}
