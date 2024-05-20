package com.ps;

public interface Valuable {
    public int getValue();
    default public int exudeBeauty(){
        return 10;
    };
}
