package com.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean isSorted(List<Integer> lst) {
        if (lst == null || lst.size() <= 1) {
            return true;
        }

        // Step 1: Check for duplicates count > 2
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : lst) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) > 2) {
                return false;
            }
        }

        // Step 2: Check if the list is sorted (non-decreasing)
        // We must check if lst is equal to its sorted version.
        List<Integer> sortedList = new ArrayList<>(lst);
        Collections.sort(sortedList);

        return lst.equals(sortedList);
    }
}