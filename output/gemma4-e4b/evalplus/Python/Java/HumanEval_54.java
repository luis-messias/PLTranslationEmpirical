package com.example;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * Check if two words have the same characters.
     * @param s0 The first word.
     * @param s1 The second word.
     * @return True if they contain the same set of characters, False otherwise.
     */
    public static boolean sameChars(String s0, String s1) {
        Set<Character> set0 = new HashSet<>();
        for (char c : s0.toCharArray()) {
            set0.add(c);
        }

        Set<Character> set1 = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }

        return set0.equals(set1);
    }
}