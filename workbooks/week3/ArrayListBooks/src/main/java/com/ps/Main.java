package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> libraryInventory = new ArrayList<>();

        // Statically: Insert data via the application
            Book book1 = new Book("1-111-111-1", "Title One");
            Book book2 = new Book("2-222-222-2", "Title Two");
            Book book3 = new Book("3-333-333-3", "Title Three");

            libraryInventory.add(book1);
            libraryInventory.add(book2);
            libraryInventory.add(book3);

        // Insert data via Scanner/CLI
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter details for the fourth book...");

            System.out.println("ISBN: ");
            String isbn = scanner.nextLine();

            System.out.println("Title: ");
            String title = scanner.nextLine();

            Book book4 = new Book(isbn, title);
            libraryInventory.add(book4);

        // Insert data via a file
        try{
            BufferedReader bufReader = new BufferedReader(new FileReader("books.txt"));
            String input;

            while((input = bufReader.readLine()) != null){
                String[] splitInput = input.split("\\|");
                String isbnFromFile = splitInput[0];
                String nameFromFile = splitInput[1];
                Book tempBook = new Book(isbnFromFile, nameFromFile);
                libraryInventory.add(tempBook);
            }
        } catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(libraryInventory);
    }
}