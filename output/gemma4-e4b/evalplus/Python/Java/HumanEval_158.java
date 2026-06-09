package com.example;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * Helper method to count unique characters in a string.
     */
    private static int countUniqueChars(String word) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : word.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }

    /**
     * Finds the word with the maximum number of unique characters.
     * If multiple strings have the maximum number of unique characters, 
     * returns the one which comes first in lexicographical order.
     *
     * @param words The list of strings.
     * @return The resulting word.
     */
    public static String findMax(List<String> words) {
        int maxUniqueCount = 0;
        String result = "";

        for (String word : words) {
            int currentUniqueCount = countUniqueChars(word);

            // Check if current word is better than the current result
            // 1. If unique count is strictly greater
            // 2. OR if unique count is equal AND the current word is lexicographically smaller
            if (currentUniqueCount > maxUniqueCount || 
                (currentUniqueCount == maxUniqueCount && word.compareTo(result) < 0)) {
                
                maxUniqueCount = currentUniqueCount;
                result = word;
            }
        }
        return result;
    }
}