package com.ps;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {
    private List<T> items;
    private int maxSize;

    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<T>();
    }

    public void add(T item){
        if(this.items.size() < this.maxSize){
            this.items.add(item);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<T> getItems(){
        return this.items;
    }
}
