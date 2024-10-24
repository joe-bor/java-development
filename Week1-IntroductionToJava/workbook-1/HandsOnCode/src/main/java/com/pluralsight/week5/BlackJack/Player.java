package com.pluralsight.week5.BlackJack;

import java.util.Scanner;

public class Player {
    String name;
    Hand hand;

    Player(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = scanner.nextLine();

        this.name = name;
        this.hand = new Hand();
    }
}
