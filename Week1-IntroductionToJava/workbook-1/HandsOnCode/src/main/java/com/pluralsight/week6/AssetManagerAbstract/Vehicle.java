package com.pluralsight.week6.AssetManagerAbstract;

import java.time.LocalDate;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        double value = this.getOriginalCost();
        double ogCost = this.getOriginalCost();

        int ageOfCar = LocalDate.now().getYear() - this.getYear();

        int counter = 1;
        while (counter <= ageOfCar) {
            value = switch (counter) {
                case 1, 2, 3 -> value - ogCost * .03;
                case 4, 5, 6 -> value - ogCost * 0.6;
                case 7, 8, 9 -> value - ogCost * 0.8;
                default -> 1000;
            };

//            if (counter == 1 || counter == 2 || counter == 3){
//                value -= ogCost * .03;
//            } else if (counter == 4 || counter == 5 || counter == 6) {
//                value -= ogCost * .06;
//            } else if (counter == 7 || counter == 8 || counter == 9) {
//                value -= ogCost * .08;
//            }
            counter++;
        }

        if (ageOfCar >= 10){
            value = 1000;
        }

        // above 100_000 mileage
        if (this.getOdometer() > 100000 && (!this.getMakeModel().contains("Honda") || !this.getMakeModel().contains("Toyota"))) {
            value *= .75;
        }

        return value;
    }
}
