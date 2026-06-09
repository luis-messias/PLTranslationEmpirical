package com.example;
import java.util.List;

class Solution {
    /**
     * Calculates the total number of characters in all strings of a list.
     * @param list The list of strings.
     * @return The total character count.
     */
    private long calculateTotalLength(List<String> list) {
        long total = 0;
        for (String s : list) {
            total += s.length();
        }
        return total;
    }

    /**
     * Accepts two lists of strings and returns the list that has 
     * total number of chars in all strings of the list less than or equal to the other list.
     * If the two lists have the same total number of chars, return the first list.
     *
     * @param lst1 The first list of strings.
     * @param lst2 The second list of strings.
     * @return The list satisfying the condition.
     */
    public List<String> totalMatch(List<String> lst1, List<String> lst2) {
        long c1 = calculateTotalLength(lst1);
        long c2 = calculateTotalLength(lst2);

        // If c1 <= c2, return lst1. Otherwise, return lst2.
        if (c1 <= c2) {
            return lst1;
        } else {
            return lst2;
        }
    }
}