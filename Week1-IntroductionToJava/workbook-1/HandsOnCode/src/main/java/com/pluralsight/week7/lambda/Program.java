package com.pluralsight.week7.lambda;

public class Program {

    public static void main(String[] args) {
        Creator<MagicWord> creator = () -> new MagicWord("magic");

        // --- same as above
        Creator<MagicWord> creator1 = new Creator<MagicWord>() {
            @Override
            public MagicWord create() {
                return null;
            }
        };

        // -------------
        MagicWord magicWord = creator.create();
        System.out.println(magicWord.getMagicWord());



    }
}
