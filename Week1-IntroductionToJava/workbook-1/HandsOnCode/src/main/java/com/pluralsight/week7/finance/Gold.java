package com.pluralsight.week7.finance;

public class Gold extends FixedAsset {
    private double weight;

    public Gold(double weight) {
        this.weight = weight;
    }


    @Override
    public double getValue() {
        return 0;
    }
}
