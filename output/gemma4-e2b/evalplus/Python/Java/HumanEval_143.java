package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String wordsInSentence(String sentence) {
        String[] words = sentence.split(" ");
        List<String> resultWords = new ArrayList<>();

        for (String word : words) {
            if (isPrime(word.length())) {
                resultWords.add(word);
            }
        }

        return String.join(" ", resultWords);
    }
}