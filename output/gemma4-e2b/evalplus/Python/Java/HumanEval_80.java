package com.example;
class Solution {
    public boolean isHappy(String s) {
        if (s == null || s.length() < 3) {
            return false;
        }

        int n = s.length();
        // Iterate through all possible starting indices for a triplet (i, i+1, i+2)
        for (int i = 0; i <= n - 3; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);

            // Check if any two characters in the triplet are equal
            if (c1 == c2 || c1 == c3 || c2 == c3) {
                return false;
            }
        }
        return true;
    }
}