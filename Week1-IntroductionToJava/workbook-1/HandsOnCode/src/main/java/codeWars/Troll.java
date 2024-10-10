package codeWars;


import java.util.HashSet;
import java.util.Set;

// 7 kyu - Disemvowel Trolls
public class Troll {

    public static void main(String[] args) {
        System.out.println(disemvowel("This website is for losersLOL!"));
    }

    public static String disemvowel(String str) {
        // Code away...
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : str.toCharArray()){
            if (!vowels.contains(c)){
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
