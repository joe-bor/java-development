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

    public void showHand(){
        System.out.println("------------------------------");
        System.out.println(String.format("%s's Cards", this.name));
        for (Card card : this.hand.getCards()) {
            card.flip();
            System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
            card.flip();
        }
        System.out.println("Score: " + this.hand.getValue());
    }
}
