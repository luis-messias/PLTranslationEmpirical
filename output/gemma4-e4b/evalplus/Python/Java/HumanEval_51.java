package com.example;
public class HumanEval_51 {
    /**
     * removeVowels is a function that takes string and returns string without vowels.
     * @param text The input string.
     * @return The string without vowels.
     */
    public static String removeVowels(String text) {
        return text.replaceAll("[aeiouAEIOU]", "");
    }
}