package com.pluralsight.week5.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("How many players are playing?");
        Scanner scanner = new Scanner(System.in);
        int playersNum = scanner.nextInt();
        scanner.nextLine();

        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < playersNum; i++){
            Player player = new Player();
            playerList.add(player);
        }

        // deal cards to each player
        for (int i = 0; i < 2; i++) {
            for (Player player : playerList){
                Card card = deck.deal();
                player.hand.store(card);
            }
        }

        // Display each player's hand
        for (Player player : playerList){
            System.out.println("------------------------------");
            System.out.println(String.format("%s's Cards", player.name));
            for (Card card : player.hand.getCards()) {
                card.flip();
                System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
                card.flip();
            }
            System.out.println(player.hand.getValue());
        }

        // Ask each player if they want to get another card
        System.out.println("\n--- Take another card? ---");
        for (Player player: playerList){
            System.out.printf("%s would you like to take another card ", player.name);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")){
                player.hand.store(deck.deal());
            }
        }

        // Determine each player's score
        Player currentPlayerClosestTo21 = null;
        int CurrentScoreClosestTo21 = 0;
        for (Player player : playerList){

            // Determine if their hand has an 'Ace'
            boolean hasAce = false;
            for (Card card : player.hand.getCards()){
                if (!card.isFaceUp()){
                    card.flip();
                    if (card.getValue() == "A"){
                        hasAce = true;
                    }
                    card.flip();
                }
            }

            // calculate score (proximity to 21)
            int playerHandScore = player.hand.getValue();

            if (playerHandScore > 21 && hasAce){
                playerHandScore -= 10;
            }

            // bust
            if (playerHandScore > 21 && !hasAce) {
                playerList.remove(player);
            }

                // this only runs on the first iteration
            if (currentPlayerClosestTo21 == null){
                currentPlayerClosestTo21 = player;
                CurrentScoreClosestTo21 = Math.abs(playerHandScore - 21);
            }

            if (Math.abs(playerHandScore - 21) < CurrentScoreClosestTo21){
                currentPlayerClosestTo21 = player;
                CurrentScoreClosestTo21 = playerHandScore;
            }
        }

        System.out.printf("""
                
                ************************
                %s won with score of %d
                ***************************
                """, currentPlayerClosestTo21.name, currentPlayerClosestTo21.hand.getValue());

//        // Determine which player is closest to 21 w/o going over
//        if (player1.hand.getValue() > 21  && player2.hand.getValue() > 21){
//            System.out.println("Both players went over 21. Its a draw");
//        }
//
//        if (player1.hand.getValue() > 21) {
//            System.out.println("Player 2 won! Player 1's hand went over 21");
//        }
//
//        if (player2.hand.getValue() > 21) {
//            System.out.println("Player 1 won! Player 2's hand went over 21");
//        }
//
//        int player1Score = Math.abs(player1.hand.getValue() - 21);
//        int player2Score = Math.abs(player2.hand.getValue() - 21);
//
//        if (player1Score < player2Score) {
//            System.out.println(String.format("\n%s won this round!", player1.name));
//        } else {
//            System.out.println(String.format("\n%s won this round!", player2.name));
//        }

    }
}
