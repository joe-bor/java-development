package com.pluralsight;

import java.time.LocalDate;

public class SportPlayer {
    String name;
    String sport;
    int birthYear;

    // Main one
    SportPlayer(String name, String sport, int birthYear){
        this.name = name;
        this.sport = sport;
        this.birthYear = birthYear;
    }

    // No args in constructor
    SportPlayer(){
        this.name ="Default name";
        this.sport = "Default sport";
        this.birthYear = 1;
    }

    SportPlayer(String name){
        this(name, "no sport given", 2);
    }

    SportPlayer(int birthYear){
        this("noName", "noSport", birthYear);
    }

    SportPlayer(String name, int birthYear){
        this(name, "nameAndYearGiven", birthYear);
    }


    public static void main(String[] args) {
        System.out.println("Constructor Chaining");
        SportPlayer p1 = new SportPlayer();
        System.out.println(p1.getName());
        System.out.println(p1.getSport());
        System.out.println(p1.getBirthYear());
        System.out.println("---------------");
        SportPlayer p2 = new SportPlayer("myNameIs...");
        System.out.println(p2.getName());
        System.out.println(p2.getSport());
        System.out.println(p2.getBirthYear());
        System.out.println("---------------");
        SportPlayer p3 = new SportPlayer(10);
        System.out.println(p3.getName());
        System.out.println(p3.getSport());
        System.out.println(p3.getBirthYear());
        System.out.println("---------------");
        SportPlayer p4 = new SportPlayer("nameAndYearProvided", 1231);
        System.out.println(p4.getName());
        System.out.println(p4.getSport());
        System.out.println(p4.getBirthYear());
        System.out.println("---------------");

    }

    String getName(){
        return this.name;
    }

    String getSport(){
        return this.sport;
    }

    int getBirthYear(){
        return this.birthYear;
    }
}
