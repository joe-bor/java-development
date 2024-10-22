package codeWars;

import java.util.*;

public class Dinglemouse {

    public static class HelpSaveChristmas implements Comparator<String> {

        // A map to store the correct order for each line
        private static final Map<String, Integer> ORDER = new HashMap<>();

        static {
            ORDER.put("On the 12th day of Christmas my true love gave to me", 0);
            ORDER.put("12 drummers drumming,", 1);
            ORDER.put("11 pipers piping,", 2);
            ORDER.put("10 lords a leaping,", 3);
            ORDER.put("9 ladies dancing,", 4);
            ORDER.put("8 maids a milking,", 5);
            ORDER.put("7 swans a swimming,", 6);
            ORDER.put("6 geese a laying,", 7);
            ORDER.put("5 golden rings,", 8);
            ORDER.put("4 calling birds,", 9);
            ORDER.put("3 French hens,", 10);
            ORDER.put("2 turtle doves and", 11);
            ORDER.put("a partridge in a pear tree.", 12);
        }

        @Override
        public int compare(final String line1, final String line2) {
            // Compare the lines based on their order in the map
            return Integer.compare(ORDER.get(line1), ORDER.get(line2));
        }
    }
}
