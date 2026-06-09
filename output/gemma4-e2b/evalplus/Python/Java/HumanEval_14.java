package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Return list of all prefixes from shortest to longest of the input string
     * @param string The input string
     * @return A list of all prefixes
     */
    public List<String> allPrefixes(String string) {
        List<String> prefixes = new ArrayList<>();
        int n = string.length();

        for (int i = 1; i <= n; i++) {
            prefixes.add(string.substring(0, i));
        }

        return prefixes;
    }
}