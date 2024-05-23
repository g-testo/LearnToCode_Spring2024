package com.ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<Person> people = new ArrayList<>(
//                Arrays.asList(
//                        new Person("Cloud", "Strife", 23),
//                        new Person("Tifa", "Lockhart", 20),
//                        new Person("Sephiroth", "", 29),
//                        new Person("Aerith", "Gainsborough", 22),
//                        new Person("Squall", "Leonhart", 17),
//                        new Person("Rinoa", "Heartilly", 17),
//                        new Person("Tidus", "", 17),
//                        new Person("Yuna", "", 17),
//                        new Person("Zidane", "Tribal", 16),
//                        new Person("Garnet", "Til Alexandros XVII", 16),
//                        new Person("Vivi", "Ornitier", 9),
//                        new Person("Lightning", "Farron", 21),
//                        new Person("Vanille", "", 19),
//                        new Person("Noctis", "Lucis Caelum", 20),
//                        new Person("Prompto", "Argentum", 20),
//                        new Person("Ignis", "Scientia", 22)
//                )
//        );

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Please provide me a first or last name: ");
//
//        String name = scanner.nextLine();
//
//        List<Person> filteredPeople = people.stream()
//                .filter((person)->{
//                    return (
//                            containsIgnoreCase(person.getFirstName(), name) ||
//                            containsIgnoreCase(person.getLastName(), name)
//                    );
//                })
//                .collect(Collectors.toList());
//
//        System.out.println(filteredPeople);


//        for(Person person: people){
//            if(
//                    containsIgnoreCase(person.getFirstName(), name) ||
//                    containsIgnoreCase(person.getLastName(), name)
//            ){
//                System.out.printf(
//                        "First Name: %s, Last Name: %s, Age: %d\n",
//                        person.getFirstName(),
//                        person.getLastName(),
//                        person.getAge()
//                );
//            }
//        }

//        Integer totalAges = people.stream()
//                .map(person->person.getAge())
//                .reduce(0, (accum, curr)->accum+curr);

//        Integer totalAge = people.stream()
//                .reduce(0, (accum, person) -> accum + person.getAge(), Integer::sum);


//        float totalAges = 0;
//        for(Person person: people){
//            totalAges+=person.getAge();
//        }
//        System.out.println(totalAges);
//        System.out.println(people.size());
////
//        float avg = (float)totalAges/people.size();
//
//        System.out.println(avg);


//        Integer oldest = people.stream()
//                .map(person -> person.getAge()) // [22,23,11,24,53,76]
//                .reduce(0, (accum, current)->{
//                    if(current > accum){
//                        return current;
//                    }
//                    return accum;
//                });
//        System.out.println(oldest);

//        Person oldest = people.stream()
//                .reduce(new Person("","", 0), (accum, current)->{
//                    if(current.getAge() > accum.getAge()){
//                        return current;
//                    }
//                    return accum;
//                });
//        System.out.println(oldest.getFirstName());

//        Person youngest = people.stream()
//                .reduce(null, (accum, current)->{
//                    if(accum == null || current.getAge() < accum.getAge()){
//                        return current;
//                    }
//                    return accum;
//                });
//        System.out.println(youngest.getFirstName());


//        int oldest = people.get(0).getAge();
//        for(int i=1;i<people.size();i++){
//            int currentAge = people.get(i).getAge();
//            if(currentAge > oldest){
//                oldest = currentAge;
//            }
//        }
//        System.out.println(oldest);
//
//        Person youngest = people.get(0);
//        for(int i=1;i<people.size();i++){
//            Person currentPerson = people.get(i);
//            if(currentPerson.getAge() < youngest.getAge()){
//                youngest = currentPerson;
//            }
//        }
//        System.out.println(youngest.getAge());
    }

    public static boolean containsIgnoreCase(String name1, String name2) {
        return name1.toLowerCase().contains(name2.toLowerCase());
    }
}