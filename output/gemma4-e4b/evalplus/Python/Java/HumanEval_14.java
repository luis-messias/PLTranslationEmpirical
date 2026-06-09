package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Return list of all prefixes from shortest to longest of the input string
     * @param string The input string.
     * @return List of all prefixes.
     */
    public static List<String> allPrefixes(String string) {
        List<String> prefixes = new ArrayList<>();
        for (int i = 1; i <= string.length(); i++) {
            prefixes.add(string.substring(0, i));
        }
        return prefixes;
    }
}