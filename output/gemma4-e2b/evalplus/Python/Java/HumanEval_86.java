package com.example;
import java.util.Arrays;

public class HumanEval_86 {
    public String anti_shuffle(String s) {
        String[] words = s.split(" ");
        
        String[] shuffledWords = new String[words.length];
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            // Sort the characters of the word based on their ASCII value
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            
            // Form the new word
            shuffledWords[i] = new String(chars);
        }
        
        // Join the shuffled words back with spaces