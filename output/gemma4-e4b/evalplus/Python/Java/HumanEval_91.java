package com.example;
class Solution {
    /**
     * Counts the number of "boredoms" in a string S. A boredom is a sentence 
     * that starts with the word "I ". Sentences are delimited by '.', '?', or '!'.
     * 
     * @param S The input string of words.
     * @return The count of boredoms.
     */
    public static int isBored(String S) {
        // 1. Standardize delimiters: replace '?' and '!' with '.'
        String standardizedS = S.replace("?", ".").replace("!", ".");

        // 2. Split by '.' (must escape '.' as it's a regex special character)
        String[] sentences = standardizedS.split("\\.");

        int count = 0;
        
        // 3. Iterate, trim, and check
        for (String sentence : sentences) {
            String trimmedSentence = sentence.trim();
            
            // Check if the trimmed sentence is not empty and starts with "I "
            if (!trimmedSentence.isEmpty() && trimmedSentence.startsWith("I ")) {
                count++;
            }
        }
        return count;
    }
}