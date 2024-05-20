package com.ps;

public class Gold extends FixedAsset{

    public Gold(String name, double marketValue) {
        super(name, marketValue);
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public int exudeBeauty() {
        return 0;
    }
}
