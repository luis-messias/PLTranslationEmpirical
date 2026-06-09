package com.example;
class Solution {
    /**
     * Write a function vowelsCount which takes a string representing
     * a word as input and returns the number of vowels in the string.
     * Vowels in this case are 'a', 'e', 'i', 'o', 'u'. Here, 'y' is also a
     * vowel, but only when it is at the end of the given word.
     *
     * Example:
     * >>> vowelsCount("abcde")
     * 2
     * >>> vowelsCount("ACEDY")
     * 3
     */
    public static int vowelsCount(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        String vowels = "aeiouAEIOU";

        // 1. Count standard vowels
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }

        // 2. Check for 'y' at the end
        char lastChar = s.charAt(s.length() - 1);
        if (lastChar == 'y' || lastChar == 'Y') {
            count++;
        }

        return count;
    }
}