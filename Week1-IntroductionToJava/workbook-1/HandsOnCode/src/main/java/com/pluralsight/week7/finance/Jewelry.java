package com.pluralsight.week7.finance;

public class Jewelry extends FixedAsset {
    private double karat;

    public Jewelry(String name, double karat) {
        super(name);
        this.karat = karat;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
