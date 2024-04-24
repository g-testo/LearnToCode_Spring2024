package com.ps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> libraryInventory = new ArrayList<>();

        Book book1 = new Book("1-111-111-1", "Title One");
        Book book2 = new Book("2-222-222-2", "Title Two");
        Book book3 = new Book("3-333-333-3", "Title Three");

        libraryInventory.add(book1);
        libraryInventory.add(book2);
        libraryInventory.add(book3);

        System.out.println(libraryInventory);
    }
}