package com.pluralsight.beyond.concurrency.exercises;

import java.util.concurrent.*;

public class Project {

    public static void main(String[] args) {
        ParkStatus parkStatus = new ParkStatus(100);

        Thread feedingThread = new Thread(new
                FeedingDinosaurs(parkStatus));

        Thread trackingThread = new Thread(new
                TrackingMovements(parkStatus));

        feedingThread.start();
        trackingThread.start();
    }

    static class ParkStatus {
        private int foodStock;

        public ParkStatus(int foodStock) {
            this.foodStock = foodStock;
        }

        public int getFoodStock() {
            return this.foodStock;
        }

        public void reduceFood(int amount) {
            this.foodStock -= amount;
        }
    }

    static class FeedingDinosaurs implements Runnable {
        private ParkStatus parkStatus;

        public FeedingDinosaurs(ParkStatus parkStatus) {
            this.parkStatus = parkStatus;
        }

        @Override
        public void run() {
            while (true) {
                parkStatus.reduceFood(1);
                System.out.println("Food stock after feeding: "
                        + parkStatus.getFoodStock());
            }
        }
    }

    static class TrackingMovements implements Runnable {
        private ParkStatus parkStatus;

        public TrackingMovements(ParkStatus parkStatus) {
            this.parkStatus = parkStatus;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Current food stock: " +
                        parkStatus.getFoodStock());
            }
        }

    }

}
