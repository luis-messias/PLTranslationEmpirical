package com.example;
import java.util.List;

public class HumanEval_12 {
    public static String longest(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return null;
        }

        int maxLen = 0;
        
        // Step 1: Find the maximum length
        for (String s : strings) {
            if (s != null && s.length() > maxLen) {
                maxLen = s.length();
            }
        }

        // Step 2: Find the first string with that maximum length
        for (String s : strings) {
            if (s != null && s.length() == maxLen) {
                return s;
            }
        }

        // This line should theoretically not be reached if the list was non-empty, 
        // but required for compilation if the loop structure doesn't guarantee a return.
        return null; 
    }
}