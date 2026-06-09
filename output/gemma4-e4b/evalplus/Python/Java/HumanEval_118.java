package com.example;
class Solution {

    /**
     * Helper method to check if a character is a vowel (case sensitive).
     */
    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    /**
     * Finds the closest vowel that stands between two consonants from the right side of the word.
     * 
     * @param word The input string.
     * @return The closest vowel character as a string, or an empty string if none is found.
     */
    public static String getClosestVowel(String word) {
        int n = word.length();
        
        // We need at least 3 characters for a vowel to be surrounded by two other characters.
        if (n < 3) {
            return "";
        }

        // Iterate from the second to last character (n-2) down to the second character (1).
        // This ensures that i-1 and i+1 are always valid indices, and also respects 
        // the constraint that the vowel cannot be at the beginning or end.
        for (int i = n - 2; i >= 1; i--) {
            char currentChar = word.charAt(i);
            char prevChar = word.charAt(i - 1);
            char nextChar = word.charAt(i + 1);

            // Check if currentChar is a vowel AND prevChar is a consonant AND nextChar is a consonant
            if (isVowel(currentChar) && !isVowel(prevChar) && !isVowel(nextChar)) {
                return String.valueOf(currentChar);
            }
        }
        
        return "";
    }
}