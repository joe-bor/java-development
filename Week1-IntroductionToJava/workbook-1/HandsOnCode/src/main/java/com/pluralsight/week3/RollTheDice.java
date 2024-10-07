package com.pluralsight.week3;

public class RollTheDice {
    public static void main(String[] args) {
        Dice dice = new Dice();
        int roll1 = 0;
        int roll2 = 0;

        int counter2 = 0;
        int counter4 = 0;
        int counter6 = 0;
        int counter7 = 0;


        for (int i = 0; i < 100; i++) {
            roll1 = dice.roll(1, 6);
            roll2 = dice.roll(1, 6);
            int sum = roll1 + roll2;

            System.out.printf("Roll %d: %d - %d    Sum: %d \n", i, roll1, roll2, sum);

            switch (sum) {
                case 2 -> counter2++;
                case 4 -> counter4++;
                case 6 -> counter6++;
                case 7 -> counter7++;
                default -> System.out.println();
            }
        }

            System.out.printf("""
                    Rolled 2 %d times,
                    Rolled 4 %d times,
                    Rolled 6 %d times,
                    Rolled 7 %d times,
                    """, counter2, counter4, counter6, counter7);


    }
}
