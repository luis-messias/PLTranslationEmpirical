package com.example;
import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * Given a string, find out how many distinct characters (regardless of case) does it consist of
     * @param str The input string.
     * @return The count of distinct characters.
     */
    public static int countDistinctCharacters(String str) {
        String lowerCaseStr = str.toLowerCase();
        Set<Character> distinctChars = new HashSet<>();
        for (char c : lowerCaseStr.toCharArray()) {
            distinctChars.add(c);
        }
        return distinctChars.size();
    }
}