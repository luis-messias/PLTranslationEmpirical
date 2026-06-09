package com.example;
class Solution {
    /**
     * Checks if a string is "happy".
     * A string is happy if its length is at least 3 and every 3 consecutive letters are distinct.
     *
     * @param s The input string.
     * @return true if the string is happy, false otherwise.
     */
    public boolean isHappy(String s) {
        if (s == null || s.length() < 3) {
            return false;
        }

        for (int i = 0; i <= s.length() - 3; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);

            // Check if any pair of the three consecutive characters are the same
            if (c1 == c2 || c1 == c3 || c2 == c3) {
                return false;
            }
        }
        return true;
    }
}