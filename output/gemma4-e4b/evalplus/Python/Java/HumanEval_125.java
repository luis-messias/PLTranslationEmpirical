package com.example;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Given a string of words, return a list of words split on whitespace, 
     * if no whitespaces exists in the text you should split on commas ',', 
     * if no commas exists you should return the number of lower-case letters with odd order in the
     * alphabet, ord('a') = 0, ord('b') = 1, ... ord('z') = 25
     * 
     * Note: Due to the mixed return types (List<String> or Integer), the return type is Object.
     */
    public Object splitWords(String txt) {
        // 1. Check for whitespace (using regex to detect any whitespace character)
        if (txt.matches(".*[\\s].*")) {
            // Python's split() handles various whitespace types, equivalent to splitting by one or more whitespace characters in Java.
            String[] words = txt.split("\\s+");
            return Arrays.asList(words);
        }

        // 2. Check for commas
        if (txt.contains(",")) {
            // Split by comma
            String[] words = txt.split(",");
            return Arrays.asList(words);
        }

        // 3. Count odd-ordered lowercase letters
        int count = 0;
        for (char ch : txt.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                // Calculate index: ord(ch) - ord('a')
                int index = ch - 'a';
                // Check if index is odd (1, 3, 5, ...)
                if (index % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}