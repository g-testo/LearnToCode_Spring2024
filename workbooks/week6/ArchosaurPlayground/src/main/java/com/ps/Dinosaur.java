package com.ps;

public abstract class Dinosaur extends Archosaur{
    private String locomotionStyle;
    public Dinosaur(String species, int numOfLegs, String locomotionStyle) {
        super(species, numOfLegs);
        this.locomotionStyle = locomotionStyle;
    }

    public String getLocomotionStyle() {
        return locomotionStyle;
    }

    public void setLocomotionStyle(String locomotionStyle) {
        this.locomotionStyle = locomotionStyle;
    }
}
