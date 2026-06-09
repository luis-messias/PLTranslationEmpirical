package com.example;
class Solution {
    /**
     * Checks if a string consisting only of parentheses is balanced (good).
     * A string is good if the count never drops below zero, and the final count is zero.
     */
    private boolean isValidParens(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }
            
            // If count drops below zero, it means we closed a parenthesis that wasn't opened.
            if (count < 0) {
                return false;
            }
        }
        // For the string to be balanced, the final count must be zero.
        return count == 0;
    }

    /**
     * Checks if it is possible to concatenate the two strings in some order
     * that results in a good (balanced) parentheses string.
     * 
     * @param lst A string array containing two strings of parentheses.
     * @return "Yes" if a good string can be formed, "No" otherwise.
     */
    public String matchParens(String[] lst) {
        // Check concatenation order 1: lst[0] + lst[1]
        String s1 = lst[0] + lst[1];
        boolean result1 = isValidParens(s1);

        // Check concatenation order 2: lst[1] + lst[0]
        String s2 = lst[1] + lst[0];
        boolean result2 = isValidParens(s2);

        if (result1 || result2) {
            return "Yes";
        } else {
            return "No";
        }
    }
}