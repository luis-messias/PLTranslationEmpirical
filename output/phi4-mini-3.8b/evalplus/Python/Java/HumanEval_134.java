package com.example;
public class HumanEval_134 {

    public static boolean checkIfLastCharIsALetter(String txt) {

        if (txt.length() == 0) return false;

        char lastChar = txt.charAt(txt.length() - 1);

        int spaceIndex = txt.lastIndexOf(" ");

        // Check for the conditions: not a word and is an alphabetical character

        boolean endsWithSpaceAndIsLetter = !spaceIndex < txt.length() && Character.isAlphabetic(lastChar);

        return endsWithSpaceAndIsLetter;

    }

}