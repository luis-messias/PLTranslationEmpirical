package com.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    /**
     * Given a string representing a space separated lowercase letters, return a dictionary
     * of the letter with the most repetition and containing the corresponding count.
     * If several letters have the same occurrence, return all of them.
     *
     * @param test The input string of space-separated letters.
     * @return A map containing the letters with the maximum frequency and their counts.
     */
    public Map<String, Integer> histogram(String test) {
        Map<String, Integer> count = new HashMap<>();
        
        // Handle null or empty input
        if (test == null || test.trim().isEmpty()) {
            return new HashMap<>();
        }

        // Split the string by one or more whitespace characters
        // Using trim() first ensures we don't process leading/trailing spaces unnecessarily
        String[] words = test.trim().split("\\s+");

        // 1. Count frequencies
        for (String word : words) {
            // Check if the word is not empty (though split("\\s+") usually handles this well after trim)
            if (!word.isEmpty()) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        // If no words were processed (e.g., input was just spaces)
        if (count.isEmpty()) {
            return new HashMap<>();
        }

        // 2. Find the maximum frequency
        int maxFreq = 0;
        for (int countValue : count.values()) {
            if (countValue > maxFreq) {
                maxFreq = countValue;
            }
        }

        // 3. Build the result map
        Map<String, Integer> ans = new HashMap<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == maxFreq) {
                ans.put(entry.getKey(), entry.getValue());
            }
        }

        return ans;
    }
}