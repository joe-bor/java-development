package com.pluralsight.week6.AssetManagerAbstract;

public class Cash extends Asset {


    public Cash(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

//    @Override
//    public double getValue() {
//        return 0;
//    }

    public double getValue() {
        return this.getOriginalCost();
    }
}
