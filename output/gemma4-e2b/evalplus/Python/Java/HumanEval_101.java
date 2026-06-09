package com.example;
class Solution {
    public String[] wordsString(String s) {
        // Replace commas with spaces
        String sModified = s.replace(",", " ");
        
        // Split the string by one or more whitespace characters
        String[] words = sModified.split("\\s+");
        
        // The filtering step in Python (if word != "") is implicitly handled by split("\\s+") 
        // when dealing with standard word separation, but we return the resulting array.
        return words;
    }
}