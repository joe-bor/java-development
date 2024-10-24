package com.pluralsight.week5.BlackJack;

public class App {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player1 = new Player();
        Player player2 = new Player();

        // deal cards to each player
        for (int i = 0; i < 2; i++) {
            Card card1 = deck.deal();
            player1.hand.store(card1);

            Card card2 = deck.deal();
            player2.hand.store(card2);
        }


        // Display each player's hand
        System.out.println("------------------------------");
        System.out.println("Player 1's Cards");
        for (Card card : player1.hand.getCards()) {
            card.flip();
            System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
            card.flip();
        }
        System.out.println(player1.hand.getValue());

        System.out.println("------------------------------");
        System.out.println("Player 2's Cards");
        for (Card card : player2.hand.getCards()) {
            card.flip();
            System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
            card.flip();
        }
        System.out.println(player2.hand.getValue());


        // Determine which player is closest to 21 w/o going over
        if (player1.hand.getValue() > 21  && player2.hand.getValue() > 21){
            System.out.println("Both players went over 21. Its a draw");
        }

        if (player1.hand.getValue() > 21) {
            System.out.println("Player 2 won! Player 1's hand went over 21");
        }

        if (player2.hand.getValue() > 21) {
            System.out.println("Player 1 won! Player 2's hand went over 21");
        }

        int player1Score = Math.abs(player1.hand.getValue() - 21);
        int player2Score = Math.abs(player2.hand.getValue() - 21);

        if (player1Score < player2Score) {
            System.out.println(String.format("\n%s won this round!", player1.name));
        } else {
            System.out.println(String.format("\n%s won this round!", player2.name));
        }

    }
}
