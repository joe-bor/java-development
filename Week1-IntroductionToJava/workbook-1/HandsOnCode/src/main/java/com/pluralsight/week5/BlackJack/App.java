package com.pluralsight.week5.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static final int INIT_CARDS_DEALT = 2;
    public static final List<Player> playerList = initPlayers();

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        // deal cards to each player
        for (int i = 0; i < INIT_CARDS_DEALT; i++) {
            for (Player player : playerList) {
                Card card = deck.deal();
                player.hand.store(card);
            }
        }

        // Display each player's hand
        for (Player player : playerList) {
            player.showHand();
        }

        // Ask each player if they want to get another card
        System.out.println("\n--- Take another card? ---");
        Scanner scanner = new Scanner(System.in);
        for (Player player : playerList) {
            System.out.printf("%s would you like to take another card ", player.name);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                player.hand.store(deck.deal());
            }
        }
        scanner.close();

        // Display each player's hand (AGAIN, after potential extra draws)
        for (Player player : playerList) {
            player.showHand();
        }

        // Determine each player's score
        Player currentPlayerClosestTo21 = null;
        int CurrentScoreClosestTo21 = 0;
        for (Player player : playerList) {

            // Determine if their hand has an 'Ace'
            boolean hasAce = false;
            for (Card card : player.hand.getCards()) {
                if (!card.isFaceUp()) {
                    card.flip();
                    if (card.getValue().equalsIgnoreCase("A")) {
                        hasAce = true;
                    }
                    card.flip();
                }
            }

            // calculate score (proximity to 21)
            int playerHandScore = player.hand.getValue();

            if (playerHandScore > 21 && hasAce) {
                playerHandScore -= 10;
            }

            // bust
            if (playerHandScore > 21 && !hasAce) {
                playerList.remove(player);
                continue;
            }

            // this only runs on the first iteration
            if (currentPlayerClosestTo21 == null) {
                currentPlayerClosestTo21 = player;
                CurrentScoreClosestTo21 = Math.abs(playerHandScore - 21);
            }

            if (Math.abs(playerHandScore - 21) < CurrentScoreClosestTo21) {
                currentPlayerClosestTo21 = player;
                CurrentScoreClosestTo21 = playerHandScore;
            }
        }

        System.out.printf("""
                
                ************************
                %s won with score of %d
                ***************************
                """, currentPlayerClosestTo21.name, currentPlayerClosestTo21.hand.getValue());

    }

    private static List<Player> initPlayers() {
        System.out.println("How many players are playing?");
        Scanner scanner = new Scanner(System.in);
        int playersNum = scanner.nextInt();
        scanner.nextLine();

        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < playersNum; i++) {
            Player player = new Player();
            playerList.add(player);
        }

        scanner.close();
        return playerList;
    }
}
