package com.pluralsight.week3;

public class Vehicle {

    long vehicleId;
    String makeModel;
    String color;
    int odoMeterReading;
    float price;

    public Vehicle(long vehicleId, String makeModel, String color, int odoMeterReading, float price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odoMeterReading = odoMeterReading;
        this.price = price;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdoMeterReading() {
        return odoMeterReading;
    }

    public void setOdoMeterReading(int odoMeterReading) {
        this.odoMeterReading = odoMeterReading;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
