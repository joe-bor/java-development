package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeCalculation {

    public static void main(String[] args) {
        LocalTime time = LocalTime.of(10, 0);
        LocalTime newTime = time.plusMinutes(61);

        System.out.println("It is " + time);
        System.out.println("After 61 minutes it'll be " + newTime);
    }


}
