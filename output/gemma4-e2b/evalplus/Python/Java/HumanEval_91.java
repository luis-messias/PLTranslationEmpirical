package com.example;
class Solution {
    public int isBored(String S) {
        // Replace '?' and '!' with '.' to unify delimiters
        String tempS = S.replace('?', '.').replace('!', '.');

        // Split the string by '.'
        String[] sentences = tempS.split("\\.");

        int boredCount = 0;
        for (String sentence : sentences) {
            // Trim leading/trailing whitespace (equivalent to Python's .strip())
            String trimmedSentence = sentence.trim();
            
            // Check if the sentence starts with "I "
            if (trimmedSentence.startsWith("I ")) {
                boredCount++;
            }
        }
        return boredCount;
    }
}