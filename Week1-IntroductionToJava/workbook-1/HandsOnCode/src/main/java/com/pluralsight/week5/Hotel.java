package com.pluralsight.week5;

import java.util.List;

public class Hotel {
    String name;
    int numberOfSuites;
    int numberOfRooms;
    int bookedSuites;
    int bookedRooms;

    // CONSTRUCTORS:
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    // GETTERS & SETTERS:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public void setNumberOfSuites(int numberOfSuites) {
        this.numberOfSuites = numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public void setBookedSuites(int bookedSuites) {
        this.bookedSuites = bookedSuites;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(int bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    // OTHERS METHODS:
    public int getAvailableSuites(){
        return this.getNumberOfSuites() - this.getBookedSuites();
    }

    public int getAvailableRooms(){
        return this.getNumberOfRooms() - this.getBookedRooms();
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite){

        if (isSuite){
            if (this.getAvailableSuites() < numberOfRooms){
                return true;
            }
        } else {
            if (this.getAvailableRooms() < numberOfRooms){
                return true;
            }
        }
        return false;
    }
}
