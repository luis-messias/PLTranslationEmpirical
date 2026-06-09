package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Given a string s and a natural number n, returns a list of all words from string s 
     * that contain exactly n consonants, in order these words appear in the string s.
     * Assumes input string contains only letters and spaces.
     */
    public List<String> selectWords(String s, int n) {
        List<String> ans = new ArrayList<>();
        
        if (s == null || s.isEmpty()) {
            return ans;
        }

        // Split by one or more whitespace characters to get clean words
        String[] words = s.split("\\s+");
        
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            
            int c_cnt = 0;
            
            // Calculate consonant count
            for (char c : word.toCharArray()) {
                // Check if the character is a letter
                if (Character.isLetter(c)) {
                    char lowerC = Character.toLowerCase(c);
                    
                    // Check if it is NOT a vowel
                    if (lowerC != 'a' && lowerC != 'e' && lowerC != 'i' && lowerC != 'o' && lowerC != 'u') {
                        c_cnt++;
                    }
                }
            }
            
            if (c_cnt == n) {
                ans.add(word);
            }
        }
        return ans;
    }
}