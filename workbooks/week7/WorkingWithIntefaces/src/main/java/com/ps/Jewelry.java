package com.ps;

public class Jewelry extends FixedAsset implements Wearable {

    public Jewelry(String name, double marketValue) {
        super(name, marketValue);
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public int exudeBeauty() {
        int wear = Wearable.super.exudeBeauty();
        int val = super.exudeBeauty();
        return 0;
    }
}
