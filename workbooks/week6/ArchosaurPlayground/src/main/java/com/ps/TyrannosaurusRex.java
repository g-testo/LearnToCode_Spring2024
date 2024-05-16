package com.ps;

public class TyrannosaurusRex extends Dinosaur{
    private float jawStrPsi;

    public TyrannosaurusRex(float jawStrPsi) {
        super("Tyrannosaurus Rex", 2, "Bipedal");
        this.jawStrPsi = jawStrPsi;
    }

    @Override
    public void eat() {
        this.energy += 25;
    }

    @Override
    public void sleep() {
        this.energy += 50;
    }

    @Override
    public void move() {
        this.energy -= 25;
    }

    public float getJawStrPsi() {
        return jawStrPsi;
    }

    public void setJawStrPsi(float jawStrPsi) {
        this.jawStrPsi = jawStrPsi;
    }
}
