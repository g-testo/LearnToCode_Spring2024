package com.ps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Archosaur

        // Pterosaurs
        // Pterodactyl

        // Dinosaurs
        // Triceratops
        // TyrannosaurusRex
        // Brachiosaurus
        // Velociraptor
        // Oviraptor

        TyrannosaurusRex rex1 = new TyrannosaurusRex( 12000);
        TyrannosaurusRex rex2 = new TyrannosaurusRex( 13000);
        TyrannosaurusRex rex3 = new TyrannosaurusRex( 14000);
        Pterodactyl ptero1 = new Pterodactyl(20.0f);
        Pterodactyl ptero2 = new Pterodactyl(25.0f);
        Pterodactyl ptero3 = new Pterodactyl(30.0f);

        ArrayList<Archosaur> archosaurs = new ArrayList<>();

        archosaurs.add(rex1);
        archosaurs.add(rex2);
        archosaurs.add(rex3);
        archosaurs.add(ptero1);
        archosaurs.add(ptero2);
        archosaurs.add(ptero3);

        // Dindin
        for(Archosaur archo: archosaurs){
            archo.eat();
        }

        // Sleepsleep
        for(Archosaur archo: archosaurs){
            archo.sleep();
        }


    }

}