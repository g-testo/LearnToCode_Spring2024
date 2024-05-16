package com.ps;

public class Pterodactyl extends Pterosaur{

    public Pterodactyl(float wingSpan) {
        super("Pterodactyl", 2, wingSpan);
    }

    @Override
    public void eat() {
        this.energy += 25;
    }

    @Override
    public void sleep() {
        this.energy += 75;
    }

    @Override
    public void move() {
        this.energy -= 10;
    }
}
