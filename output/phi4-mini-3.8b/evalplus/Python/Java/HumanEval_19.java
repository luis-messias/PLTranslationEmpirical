package com.example;
import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_19 {

    private static final String[] TO_INT = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        System.out.println(sort("three one five")); // Example usage
    }

    private static String sort(String numbersStr) {
        if (numbersStr.isEmpty()) return "";

        int[] indices = new int[TO_INT.length];
        for (int i = 0; i < TO_INT.length; i++) {
            indices[i] = -1;
        }
        
        char[] chars = numbersStr.toLowerCase().toCharArray();
        StringBuilder sortedNumbers = new StringBuilder();

        boolean foundNextNumber = false;

        while (!foundNextNumber) {
            int minIndex = Integer.MAX_VALUE, indexOfMinElement = 0;
            
            for (int i = 0; i < TO_INT.length; i++) {
                if (indices[i] == -1 && indices[TO_INT[i].length() / Character.toUnicodeCategory().ordinal()] > chars.charAt(i)) { // Check if this character can be placed in the current position
                    minIndex = Math.min(minIndex, charToInt(TO_INT[i]));
                    indexOfMinElement = i;
                }
            }

            indices[indexOfMinElement] = 0; // Place it at its correct sorted place

            for (int j = 1; j < TO_INT.length + 1; ++j) {
                if (indices[j - 1] == chars[i]) { // Found the next number
                    foundNextNumber = true;
                    break;
                }
            }

            char[] tempChars = new char[chars.length];
            System.arraycopy(chars, indices[indexOfMinElement], tempChars, indexOfMinElement + 1, characters.indexOf(characters.charAt(indexOfMinElement)) - (indexOfMinElement + 1));
            
            sortedNumbers.append(new String(tempChars).replace(" ", ""));
        }

        return sortedNumbers.toString();
    }
    
    private static int charToInt(String str) {
        for (int i = 0; i < TO_INT.length; ++i)
            if (TO_INT[i].equals(str))
                return i;
        
        throw new IllegalArgumentException("Invalid number: " + str);
    }

}