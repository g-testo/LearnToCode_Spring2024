package com.ps;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Gregorio");

        person1.setAge(30);

        Person person2 = new Person();
        person2.setName("Jennifer");
        person2.setAge(0);

        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
