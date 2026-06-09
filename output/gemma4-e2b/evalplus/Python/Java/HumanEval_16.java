package com.example;
import java.util.HashSet;
import java.util.Set;

public class HumanEval_16 {
    public static int countDistinctCharacters(String string) {
        Set<Character> distinctChars = new HashSet<>();
        
        // Convert the string to lowercase to handle case insensitivity
        String lowerCaseString = string.toLowerCase();
        
        for (int i = 0; i < lowerCaseString.length(); i++) {
            distinctChars.add(lowerCaseString.charAt(i));
        }
        
        return distinctChars.size();
    }
}