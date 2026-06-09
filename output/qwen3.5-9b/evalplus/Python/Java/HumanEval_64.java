package com.example;
public class HumanEval_64 {
    /**
     * Write a function vowelsCount which takes a string representing
     * a word as input and returns the number of vowels in the string.
     * Vowels in this case are 'a', 'e', 'i', 'o', 'u'. Here, 'y' is also a
     * vowel, but only when it is at the end of the given word.
     * 
     * Example:
     * vowelsCount("abcde") returns 2
     * vowelsCount("ACEDY") returns 3
     */
    public static int vowelsCount(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (Character.toLowerCase(ch) == 'a' || 
                Character.toLowerCase(ch) == 'e' || 
                Character.toLowerCase(ch) == 'i' || 
                Character.toLowerCase(ch) == 'o' || 
                Character.toLowerCase(ch) == 'u') {
                cnt++;
            }
        }
        if (s.length() > 0 && Character.toLowerCase(s.charAt(s.length() - 1)) == 'y') {
            cnt++;
        }
        return cnt;
    }
}