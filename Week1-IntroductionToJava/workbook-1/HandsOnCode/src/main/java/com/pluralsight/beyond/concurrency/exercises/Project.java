package com.pluralsight.beyond.concurrency.exercises;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Project {

    public static void main(String... args) {
        ParkStatus parkStatus = new ParkStatus(100);

        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            executorService.submit(new FeedingDinosaurs(parkStatus));
            executorService.submit(new TrackingMovements(parkStatus));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    static class ParkStatus {
        private AtomicInteger foodStock;

        public ParkStatus(int foodStock) {
            this.foodStock = new AtomicInteger(foodStock);
        }

        public int getFoodStock() {
            return this.foodStock.get();
        }

        public synchronized void reduceFood(int amount) {
            this.foodStock.getAndAdd(-amount);
        }
    }

    static class FeedingDinosaurs implements Runnable {
        private ParkStatus parkStatus;

        public FeedingDinosaurs(ParkStatus parkStatus) {
            this.parkStatus = parkStatus;
        }

        @Override
        public void run() {
            while (parkStatus.getFoodStock() != 0) {
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
            while (parkStatus.getFoodStock() != 0) {
                System.out.println("Current food stock: " +
                        parkStatus.getFoodStock());
            }
        }

    }

}

/*
 * Solving race condition:
 *   - perhaps change foodStock from int to AtomicInteger
 *       - and its corresponding getters and setters to leverage the methods of AtomicInteger
 *
 *
 *
 * */
