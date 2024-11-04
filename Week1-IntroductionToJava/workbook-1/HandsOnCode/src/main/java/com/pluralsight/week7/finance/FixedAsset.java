package com.pluralsight.week7.finance;

public abstract class FixedAsset implements Valuable {
    private String name;
    private double marketValue;

    public FixedAsset(String name, double marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }


    public FixedAsset(String name) {
        this.name = name;
    }

    public FixedAsset() {
    }
}
