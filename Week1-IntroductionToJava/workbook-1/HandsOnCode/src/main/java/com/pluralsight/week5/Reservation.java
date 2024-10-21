package com.pluralsight.week5;

class Reservation {
    private float price;
    private int numberOfNights;
    private String roomType;
    private boolean isWeekend;

     Reservation(float price, int numberOfNights, String roomType, boolean isWeekend) {
        this.price = price;
        this.numberOfNights = numberOfNights;
        this.roomType = roomType;
        this.isWeekend = isWeekend;
    }

     Reservation(int numberOfNights, String roomType, boolean isWeekend){
        this(roomType.equals("king") ? 139.0f : 124.0f * (isWeekend ? 1.1f : 1f), numberOfNights, roomType, isWeekend);
    }

    // GETTERS & SETTERS:
    public String getRoomType(){
        return roomType;
    }

    public void setRoomType(String roomType) throws RoomTypeException {
         if (!roomType.equalsIgnoreCase("king") || !roomType.equalsIgnoreCase("double")){
             throw new RoomTypeException("Room type has to be either king or double");
         }
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public void setIsWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public float getReservationTotal() {
        float pricePerNight = this.getRoomType().equals("king") ? 139.0f : 124.0f;
        pricePerNight *= this.isWeekend() ? 1.1f : 1f;

        return (pricePerNight * this.getNumberOfNights());
    }
}