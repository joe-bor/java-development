package com.pluralsight.week5;

class Room {
    int numberOfBeds;
    int price;
    boolean isOccupied;
    boolean isDirty;

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return this.isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isAvailable() {
        return (!isDirty() && !isOccupied());
    }

    public void checkIn() {
        this.setDirty(true);
        this.setOccupied(true);
    }

    public void checkOut() {
        this.cleanRoom();
        this.setOccupied(false);
    }

    public void cleanRoom() {
        this.setDirty(false);
    }
}