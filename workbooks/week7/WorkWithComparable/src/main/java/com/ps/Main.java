package com.ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Person spongeBob = new Person("SpongeBob", "SquarePants", 20);

        Integer longNum = spongeBob.displayWithLabel("Hello", new Integer(2000));
        Integer inty = spongeBob.displayWithLabel("World", 10);
//        spongeBob.displayWithLabel("dsfsdj", "World");






        Person patrick = new Person("Patrick", "Star", 21);

        people.add(spongeBob);
        people.add(patrick);
        people.add(new Person("Sandy", "Cheeks", 22));
        people.add(new Person("Squidward", "Tentacles", 24));
        people.add(new Person("Mr.", "Krabs", 55));
        people.add(new Person("Plankton", "Sheldon", 35));
        people.add(new Person("Gary", "Snail", 5));
        people.add(new Person("Pearl", "Krabs", 16));
        people.add(new Person("Mrs.", "Puff", 45));
        people.add(new Person("Larry", "Lobster", 30));

        Collections.sort(people);

        System.out.println(people);

    }
}