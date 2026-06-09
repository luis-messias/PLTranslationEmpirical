package com.example;
class Solution {
    /**
     * Find how many times a given substring can be found in the original string. Count overlapping cases.
     * @param string The original string.
     * @param substring The substring to search for.
     * @return The number of occurrences.
     */
    public static int howManyTimes(String string, String substring) {
        if (substring.isEmpty()) {
            // Depending on requirements, this might throw an exception or return 0.
            // Given the logic of finding occurrences, 0 is safer if the substring is empty.
            return 0;
        }

        int occurrences = 0;
        int subLength = substring.length();
        int stringLength = string.length();

        for (int i = 0; i <= stringLength - subLength; i++) {
            // Check if the substring starting at index i matches the target substring
            if (string.substring(i, i + subLength).equals(substring)) {
                occurrences++;
            }
        }
        return occurrences;
    }
}