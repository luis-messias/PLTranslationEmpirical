package com.example;
import java.util.Map;

class Solution {
    /**
     * Given a dictionary (Map), return True if all keys are strings in lower 
     * case or all keys are strings in upper case, else return False.
     * The function should return False if the given dictionary is empty.
     * 
     * @param dict The input map. Keys are treated as potential strings.
     * @return True if all keys are consistently cased (all lower or all upper), False otherwise.
     */
    public static boolean checkDictCase(Map<?, ?> dict) {
        if (dict == null || dict.isEmpty()) {
            return false;
        }

        boolean allLower = true;
        boolean allUpper = true;

        for (Object key : dict.keySet()) {
            // 1. Check if the key is a String
            if (!(key instanceof String)) {
                return false;
            }

            String sKey = (String) key;

            // 2. Check if the key is lowercase
            // A string is lowercase if it equals its lowercase version.
            if (!sKey.equals(sKey.toLowerCase())) {
                allLower = false;
            }

            // 3. Check if the key is uppercase
            // A string is uppercase if it equals its uppercase version.
            if (!sKey.equals(sKey.toUpperCase())) {
                allUpper = false;
            }

            // Optimization: If both conditions have failed, we can stop early.
            if (!allLower && !allUpper) {
                return false;
            }
        }

        return allLower || allUpper;
    }
}