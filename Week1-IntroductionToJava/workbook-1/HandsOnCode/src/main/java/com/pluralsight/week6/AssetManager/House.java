package com.pluralsight.week6.AssetManager;

public class House extends Asset{
    private String address;
    private int condition; //1 - excellent, 2-god, 3-fair, 4-poor
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue(){

        double pricePerSqFt = switch (this.getCondition()){
            case 1 -> 180.00;
            case 2 -> 130.00;
            case 3 -> 90.00;
            case 4 -> 80.00;
            default -> 0.00;
        };

        return (pricePerSqFt * this.getSquareFoot()) + (0.25 * this.getLotSize());
    }
}
