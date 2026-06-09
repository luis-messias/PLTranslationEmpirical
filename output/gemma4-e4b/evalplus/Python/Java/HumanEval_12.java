package com.example;
import java.util.List;

class Solution {
    /**
     * Out of list of strings, return the longest one. Return the first one in case of multiple
     * strings of the same length. Return null in case the input list is empty.
     * 
     * @param strings The list of strings.
     * @return The longest string, or null if the list is empty.
     */
    public String longest(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return null;
        }

        String result = null;
        int maxLength = -1;

        for (String s : strings) {
            int currentLength = s.length();

            // We only update the result if we find a strictly longer string.
            // This ensures that if multiple strings have the same maximum length, 
            // we keep the first one encountered.
            if (currentLength > maxLength) {
                maxLength = currentLength;
                result = s;
            }
        }
        
        return result;
    }
}