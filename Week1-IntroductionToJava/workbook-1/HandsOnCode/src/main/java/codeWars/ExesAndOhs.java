package codeWars;

import java.util.ArrayList;
import java.util.List;

public class ExesAndOhs {
    public static void main(String[] args) {
        System.out.println( getXO("xoxoxXOXO"));
        System.out.println(getXO("aeasdasds"));
    }

    public static boolean getXO (String str) {
        String newStr = str.toLowerCase();
        // Good Luck!!
        List<String> exes = new ArrayList<>();
        List<String> os = new ArrayList<>();

        for (int i = 0; i < str.length(); i++){
            char currentChar = newStr.charAt(i);
            if (currentChar == 'x') exes.add(String.valueOf(currentChar));
            if (currentChar == 'o') os.add(String.valueOf(currentChar));
        }

        if (exes.isEmpty() && os.isEmpty()) return true;
        return exes.size() == os.size();
    }
}
