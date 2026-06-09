package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {

    /**
     * Checks if a given integer is a prime number.
     */
    private static boolean isPrime(int a) {
        if (a < 2) return false;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string containing words from the original sentence whose lengths are prime numbers,
     * maintaining the original order.
     */
    public String wordsInSentence(String sentence) {
        // Split the sentence by spaces
        String[] words = sentence.split(" ");
        
        List<String> resultWords = new ArrayList<>();
        
        // Filter words based on prime length
        for (String word : words) {
            if (!word.isEmpty()) {
                if (isPrime(word.length())) {
                    resultWords.add(word);
                }
            }
        }
        
        // Join the resulting words back into a single string separated by spaces
        return String.join(" ", resultWords);
    }
}