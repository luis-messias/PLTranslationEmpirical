package com.example;
import java.util.List;
import java.util.Optional;

public class HumanEval_12 {

    public static Optional<String> longest(List<String> strings) {
        // Out of list of strings, return the longest one. Return the first one in case of multiple
        // strings of the same length. Return None (Optional.empty()) in case the input list is empty.
        
        if (strings == null || strings.isEmpty()) {
            return Optional.empty();
        }

        String maxStr = strings.get(0);
        int maxLen = Integer.MAX_VALUE;

        for (String s : strings) {
            if (s.length() > maxLen) {
                maxLen = s.length();
                maxStr = s;
            } else if (s.length() == maxLen && !maxStr.equals(s)) { // Return the first occurrence in case of ties
                return Optional.of(maxStr);
            }
        }

        return Optional.ofNullable(maxStr); // Handle null values gracefully, though not expected here.
    }

}