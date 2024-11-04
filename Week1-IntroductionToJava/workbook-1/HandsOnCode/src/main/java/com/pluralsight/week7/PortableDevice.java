package com.pluralsight.week7;

public abstract class PortableDevice extends Device implements Chargeable{
    @Override
    public void charge() {
        System.out.println("chargingg..");
    }
}
