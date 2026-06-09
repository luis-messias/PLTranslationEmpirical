package com.example;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Given a list of numbers, return whether or not they are sorted
     * in ascending order. If list has more than one duplicate of the same
     * number, return False. Assume no negative numbers and only integers.
     */
    public static boolean isSorted(List<Integer> lst) {
        // 1. Check for duplicates (count > 2)
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : lst) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) > 2) {
                return false;
            }
        }

        // 2. Check if the list is sorted
        for (int i = 0; i < lst.size() - 1; i++) {
            if (lst.get(i) > lst.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}