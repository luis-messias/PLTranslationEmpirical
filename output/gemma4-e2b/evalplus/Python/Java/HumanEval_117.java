package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> selectWords(String s, int n) {
        List<String> ans = new ArrayList<>();
        
        // Split the string by spaces. Using split(" ") handles the exact behavior of the Python split(" ").
        String[] words = s.split(" ");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                int c_cnt = 0;
                // Count consonants
                for (char ch : word.toCharArray()) {
                    // Check if the character is NOT a vowel (case insensitive)
                    boolean isVowel = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                                      ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
                    
                    if (!isVowel) {
                        c_cnt++;
                    }
                }
                
                if (c_cnt == n) {
                    ans.add(word);
                }
            }
        }
        return ans;
    }
}