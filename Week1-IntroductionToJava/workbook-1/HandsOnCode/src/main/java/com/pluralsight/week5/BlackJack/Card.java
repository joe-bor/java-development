package com.pluralsight.week5.BlackJack;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;
    static Map<String, Integer> numToValue = new HashMap<>();

    static {
        numToValue.put("1", 1);
        numToValue.put("2", 2);
        numToValue.put("3", 3);
        numToValue.put("4", 4);
        numToValue.put("5", 5);
        numToValue.put("6", 6);
        numToValue.put("7", 7);
        numToValue.put("8", 8);
        numToValue.put("9", 9);
        numToValue.put("10", 10);
        numToValue.put("A", 11);
        numToValue.put("K", 10);
        numToValue.put("Q", 10);
        numToValue.put("J", 10);
    }

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        // only return the suit if the card is face up
        if (isFaceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        // only return the value if the card is face up
        if (isFaceUp) {
            // this is the string value of the card
            // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        // only return the value if the card is face up
        if (isFaceUp) {
            // determine point value and return it
            return Card.numToValue.get(this.getValue());
            // A = 11
            // K, Q, J = 10
            // all numeric cards are equal to their face value
        } else {
            return 0;
        }
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}