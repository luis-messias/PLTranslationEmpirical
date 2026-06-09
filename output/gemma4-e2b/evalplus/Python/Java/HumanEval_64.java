package com.example;
class Solution {
    public int vowelsCount(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        
        // Count standard vowels (a, e, i, o, u, case-insensitive)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count++;
            }
        }

        // Check for 'y' at the end of the word
        if (s.length() > 0) {
            char lastChar = s.charAt(s.length() - 1);
            if (lastChar == 'y' || lastChar == 'Y') {
                count += 1;
            }
        }

        return count;
    }
}